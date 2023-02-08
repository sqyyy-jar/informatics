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
    implementation("com.github.sqyyy.jnb:core:1.0.1")
    annotationProcessor("org.atteo.classindex:classindex:3.13")
    annotationProcessor("com.github.sqyyy.jnb:processor:1.0.1")
}

tasks.jar {
    manifest.attributes["Main-Class"] = "informatics.Notebook"
}
