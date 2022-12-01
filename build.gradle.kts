plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "informatik"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.atteo.classindex:classindex:3.13")
    annotationProcessor("org.atteo.classindex:classindex:3.13")
}

tasks.jar {
    manifest.attributes["Main-Class"] = "informatics.Bootstrap"
}
