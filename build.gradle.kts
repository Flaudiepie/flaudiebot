plugins {
    kotlin("jvm") version "1.8.20"
    id("io.ktor.plugin") version "2.3.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application{
    mainClass.set("de.boese.soundbot.SoundbotApplicationKt")
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("net.dv8tion:JDA:5.0.0-beta.8")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

ktor {
    docker {
        jreVersion.set(io.ktor.plugin.features.JreVersion.JRE_17)
        localImageName.set("soundbot")
        imageTag.set("0.0.1-preview")
        externalRegistry.set(
            io.ktor.plugin.features.DockerImageRegistry.dockerHub(
                appName = provider { "flaudiebot" },
                username = providers.environmentVariable("DOCKER_HUB_PERSONAL_USERNAME"),
                password = providers.environmentVariable("DOCKER_HUB_PERSONAL_PASSWORD")
            )
        )
    }
}