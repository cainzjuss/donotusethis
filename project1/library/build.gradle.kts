plugins {
    id("groovy") 
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.micronaut.application") version "4.3.2"
    id("io.micronaut.aot") version "4.3.2"
}

version = "0.1"
group = "com.example"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.micronaut.data:micronaut-data-jpa")
    implementation("io.micronaut:micronaut-validation:3.5.1")
    implementation("io.micronaut:micronaut-inject-java")
    implementation("io.micronaut:micronaut-validation")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut:micronaut-http-client")
    runtimeOnly("ch.qos.logback:logback-classic")
    implementation("io.micronaut.data:micronaut-data-jdbc")
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa")
    implementation("io.micronaut.data:micronaut-data-tx-hibernate")
    //implementation("io.micronaut.data:micronaut-data-rx-hibernate")
    implementation("org.postgresql:postgresql")
    runtimeOnly("org.yaml:snakeyaml:1.29")
    annotationProcessor("io.micronaut.data:micronaut-data-processor")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("javax.inject:javax.inject:1")
    implementation("org.hibernate:hibernate-core:5.4.21.Final")
    //implementation("jakarta.persistence:jakarta.persistence-api:2.2.3")
    implementation("org.apache.groovy:groovy:4.0.18")
    //implementation("io.micronaut.sql:micronaut-vertx-pg-client")
    //implementation("io.micronaut:micronaut-inject-groovy")
    //implementation("io.micronaut:micronaut-runtime-groovy")
    //implementation("io.micronaut:micronaut-function-groovy")
    // io.micronaut:micronaut-inject-groovy  io.micronaut:micronaut-runtime-groovy  io.micronaut:micronaut-function-groovy  
    //16.2 Built-In Endpoints
    annotationProcessor("io.micronaut.validation:micronaut-validation-processor")
    // Jacksoni sõltuvused JSON töötluseks
    runtimeOnly("io.micronaut:micronaut-jackson-databind:4.3.8")

    // Health Check sõltuvus
    implementation("io.micronaut:micronaut-management")

    // Jätkates eelnevatele sõltuvustele
    testImplementation("io.micronaut.test:micronaut-test-junit5")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    
    // Kui soovite kasutada Spocki Groovy testide jaoks
    testImplementation("org.spockframework:spock-core:2.0-M5-groovy-3.0")
    testImplementation("org.apache.groovy:groovy:4.0.18")
}



application {
    mainClass.set("com.example.Application")
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
        annotations("com.example.*")
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



