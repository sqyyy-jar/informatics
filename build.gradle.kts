plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "informatics"
version = "1.1.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation("com.github.sqyyy.jnb:core:1.0.1")
    annotationProcessor("com.github.sqyyy.jnb:processor:1.0.1")
}

tasks.jar {
    manifest.attributes["Main-Class"] = "informatics.Notebook"
}
