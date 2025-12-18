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
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2"
    )
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}