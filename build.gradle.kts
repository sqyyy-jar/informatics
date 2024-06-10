plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "informatics"
version = "0.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.github.sqyyy.jnb:core:1.0.1") {
        version { branch = "main" }
    }
    annotationProcessor("com.github.sqyyy.jnb:processor:1.0.1") {
        version { branch = "main" }
    }
}

tasks.jar {
    manifest.attributes["Main-Class"] = "informatics.Notebook"
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "failed")
    }
}