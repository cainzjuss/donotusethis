plugins {
    id("groovy") 
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.3.2"
    id("io.micronaut.aot") version "4.3.2"
}

version = "0.1"
group = "workffs"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.micronaut.groovy:micronaut-runtime-groovy")
    implementation("io.micronaut.serde:micronaut-serde-jackson")
    implementation("io.micronaut.sql:micronaut-vertx-pg-client")
    compileOnly("io.micronaut:micronaut-http-client")
    compileOnly("io.micronaut:micronaut-http-validation")
    compileOnly("io.micronaut.serde:micronaut-serde-processor")
    runtimeOnly("ch.qos.logback:logback-classic")
    testImplementation("io.micronaut:micronaut-http-client")
    //implementation("io.micronaut.data:micronaut-data-hibernate-reactive")
    //implementation("io.vertx:vertx-pg-client")
    implementation("io.micronaut:micronaut-management")
}


application {
    mainClass.set("workffs.Application")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}


graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("spock2")
    processing {
        incremental(true)
        annotations("workffs.*")
    }
    aot {
    // Please review carefully the optimizations enabled below
    // Check https://micronaut-projects.github.io/micronaut-aot/latest/guide/ for more details
        optimizeServiceLoading.set(false)
        convertYamlToJava.set(false)
        precomputeOperations.set(true)
        cacheEnvironment.set(true)
        optimizeClassLoading.set(true)
        deduceEnvironment.set(true)
        optimizeNetty.set(true)
    }
}



