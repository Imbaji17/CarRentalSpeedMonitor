plugins {
    kotlin("jvm") version "1.9.0"
}

allprojects {
    group = "com.carrental"
    version = "1.0-SNAPSHOT"
}

subprojects {
    repositories {
        mavenCentral()
    }
}
