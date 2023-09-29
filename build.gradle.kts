plugins {
    java
    id("org.springframework.boot") version "3.0.6"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.sonarqube") version "3.5.0.2730"
}

group = "com.finace"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    developmentOnly
    runtimeClasspath {
        extendsFrom(configurations.developmentOnly.get())
    }
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

//sonarqube {
//    properties {
//        property "sonar.projectKey", "jacobryuu_finance-analysis"
//        property "sonar.organization", "jacob1225"
//        property "sonar.host.url", "https://sonarcloud.io"
//    }
//}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.0")

    //http
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("org.apache.httpcomponents:httpclient:4.5.14")

    implementation("com.yahoofinance-api:YahooFinanceAPI:3.17.0")
    // The client
    implementation("io.prometheus:simpleclient:0.16.0")

    // Hotspot JVM metrics
    implementation("io.prometheus:simpleclient_hotspot:0.16.0")

    // Exposition HTTPServer
    implementation("io.prometheus:simpleclient_httpserver:0.16.0")
    // Pushgateway exposition
    implementation("io.prometheus:simpleclient_pushgateway:0.16.0")


    implementation("org.flywaydb:flyway-core")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")


//    runtimeOnly("io.micrometer:micrometer-registry-new-relic")
    runtimeOnly("io.micrometer:micrometer-registry-prometheus")

    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
