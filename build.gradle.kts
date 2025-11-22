plugins {
    kotlin("jvm") version "2.2.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(
        "org.jetbrains.kotlinx:kotlinx-coroutines:1.3.9"
    )
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}