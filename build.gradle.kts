plugins {
    kotlin("jvm") version "1.9.0" apply false
}

group = "ru.tinkoff.piapi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
    }

    val testImplementation by configurations
    val testRuntimeOnly by configurations
    val implementation by configurations
    dependencies {
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
        implementation("io.grpc:grpc-kotlin-stub:1.3.0")
        implementation("io.grpc:grpc-protobuf:1.57.1")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_1_8.toString()
        targetCompatibility = JavaVersion.VERSION_1_8.toString()
        options.encoding = "UTF-8"
    }

    tasks.getByName<Test>("test") {
        useJUnitPlatform()
    }
}