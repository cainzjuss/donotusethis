
package com.example.demo

import spock.lang.Specification
import io.micronaut.test.extensions.spock.annotation.MicronautTest

@MicronautTest
class BookControllerSpec extends Specification {

    def "test something"() {
        expect:
        true
    }
}