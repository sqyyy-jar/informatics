plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "informatics"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.github.com/sqyyy-jar/java-notebooks")
        credentials {
            username = System.getenv("GRADLE_GITHUB_USERNAME")
            password = System.getenv("GRADLE_GITHUB_TOKEN")
        }
    }
}

dependencies {
    implementation("org.atteo.classindex:classindex:3.13")
    implementation("com.github.sqyyy.jnb:core:0.1.0-alpha")
    annotationProcessor("org.atteo.classindex:classindex:3.13")
    annotationProcessor("com.github.sqyyy.jnb:processor:0.1.0-alpha")
}

tasks.jar {
    manifest.attributes["Main-Class"] = "informatics.Bootstrap"
}
