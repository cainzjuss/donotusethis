package com.example

import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic
import io.micronaut.core.annotation.Introspected
import javax.persistence.Entity

@CompileStatic
//@Introspected(packages = "com.example.library.domain", includedAnnotations = Entity.class)
class Application {

    static void main(String[] args) {
        Micronaut.run(Application, args)
    }
}
