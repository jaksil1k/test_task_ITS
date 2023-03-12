package com.example.test_task.service

import com.example.test_task.entity.Location
import com.example.test_task.entity.User
import com.example.test_task.repositry.LocationRepository
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import spock.lang.Specification
import spock.lang.Subject

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE

//@SpringBootTest(webEnvironment = NONE)
class LocationServiceTest extends Specification{
    @Subject LocationService locationService;

    LocationRepository repository = Mock();

    def setup () {
        locationService = new LocationService(repository);
    }

    def 'create() should return location with id'() {
        setup:
        def authentication = Mock(Authentication)
        def securityContext = Mock(SecurityContext)
        SecurityContextHolder.setContext(securityContext)

        1 * securityContext.getAuthentication() >> authentication
        1 * repository.save(_) >> new Location(1, "some name", "some place")
        1 * authentication.getPrincipal() >> new User()

        when:
        def result = locationService.create(new Location("some name", "some place"))
        then:
        result.getId() == 1
    }

    def 'create() should throw exception if location is null'() {
        when:
        locationService.create(null)
        then:
        thrown(NullPointerException)
    }

    def 'create() should throw exception if location name or address is blank or null'() {
        when:
        locationService.create(new Location(name, address))
        then:
        thrown(Exception)
        where:
        name| address
        ""  | ""
        ""  | null
        null| ""
        null|null
    }

    def 'getAllLocationsByUserEmail() should return 3 locations'() {
        given:
        def email = "nartai53@gmail.com"
        1 * repository.getAllLocationsByUserEmail(email) >> [new Location(), new Location(), new Location()]
        when:
        def locations = locationService.getAllLocationsByUserEmail(email)
        then:
        locations.size() == 3
    }

    def 'getAllLocationsByUserEmail() should throw Exception if email is invalid'() {
        when:
        locationService.getAllLocationsByUserEmail(email)
        then:
        thrown(RuntimeException)
        where:
        email| variable
        null | null
        "invalidEmail"| null

    }

    def 'getById() should return location'() {
        given:
        def location  = Optional.of(new Location(1, "some name", "some address"))
        1 * repository.findById(location.get().getId()) >> location
        when:
        def result = locationService.getById(location.get().getId())
        then:
        result == location
    }

    def 'getById() should throw Exception if id is null or less than 1'() {
        when:
        locationService.getById(id)
        then:
        thrown(RuntimeException)
        where:
        id| variable
        null | null
        -100 | null

    }
}
