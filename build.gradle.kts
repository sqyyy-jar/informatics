plugins {
    id("java")
}

group = "informatik"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.jar {
    manifest.attributes["Main-Class"] = "informatik.Bootstrap"
}
