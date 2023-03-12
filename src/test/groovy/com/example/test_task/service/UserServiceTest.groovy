package com.example.test_task.service

import com.example.test_task.entity.User
import com.example.test_task.repositry.UserRepository
import spock.lang.Specification
import spock.lang.Subject

class UserServiceTest extends Specification {
    @Subject UserService service;

    UserRepository repository = Mock()


    void setup() {
        service = new UserService(repository)
    }

    def "create() should return user successfully"() {
        setup:
        def user = new User("nartai53@gmail.com", "zhaksylyk", "5")

        1 * repository.save(user) >> user
        expect:
        service.create(user) == user
    }
    def "create() should throw exception if email is invalid"() {
        setup:
        def user = new User();
        user.setEmail("invalidEmail")
        when:
        service.create(user)
        then:
        thrown(RuntimeException)
    }

    def "loadUserByUsername() should work" () {
        setup:
        def user = Optional.of(new User())
        def email = "example@gmail.com"
        1 * repository.findByEmail(email) >> user
        expect:
        service.loadUserByUsername(email) == user.get()
    }

    def "loadUserByUsername() should throw exception if user is empty" () {
        setup:
        def email = "example@gmail.com"
        1 * repository.findByEmail(email) >> Optional.empty()
        when:
        service.loadUserByUsername(email)
        then:
        thrown(RuntimeException)
    }
    def "GetByEmail"() {
    }
}
