package com.example.test_task.service

import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE


class Math2Test extends Specification {
    void setup() {
    }

    def test() {
        def list = [1,2,3]
        when:
        list.remove(1)
        then:
        list == [1,3]
    }

    def "Add"() {
        setup:
            def obj = new Math2()
        expect:
            obj.add(a, b) == c
        where:
            a | b | c
            1 | 2 | 3
            2 | 3 | 5
            3 | 4 | 7
    }

    def "Div"() {
        setup:
            def obj = new Math2();
            def a = 7, b = 0;
        when:
            def c = obj.div(a, b)
        then:
            thrown(ArithmeticException)
    }

    def test2() {
        def mock = Mock(Math2)
        when:
        Provider.get(1, 2, mock)
        then:
        1*mock.add(1, 1)
        1*mock.add(2, 2)
    }

}
