package com.example.test_task.service

import com.example.test_task.entity.Location
import com.example.test_task.entity.LocationShare
import com.example.test_task.entity.User
import com.example.test_task.repositry.LocationShareRepository
import spock.lang.Specification
import spock.lang.Subject


class LocationShareServiceTest extends Specification {

    @Subject LocationShareService service;

    LocationShareRepository repository = Mock();

    def setup() {
        service = new LocationShareService(repository);
    }

    def "create() should return locationShare with id"() {
        setup:
        def locationShare = new LocationShare(1, new User(), new Location(), new User(), false);

        1 * repository.save(locationShare) >> locationShare
        expect:
        service.create(locationShare) == locationShare

    }

    def "create() should throw exception if user or location is null"() {
        setup:
        def locationShare = new LocationShare(1, null, null, new User(), false);
        when:
        service.create(locationShare)
        then:
        thrown(RuntimeException)
    }

    def "create() should throw exception if user and sharedUser is equal"() {
        setup:
        User user = new User();
        def locationShare = new LocationShare(1, user, new Location(), user, false);
        when:
        service.create(locationShare)
        then:
        thrown(RuntimeException)
    }
}
