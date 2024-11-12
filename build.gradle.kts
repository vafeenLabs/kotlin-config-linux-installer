plugins {
    kotlin("jvm") version "2.0.0"
}

group = "ru.vafeen"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.sealwu:kscript-tools:1.0.2")
}

tasks.test {
    useJUnitPlatform()
}
