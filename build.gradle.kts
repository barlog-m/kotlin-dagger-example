import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    idea
    kotlin("jvm") version "1.3.21"
    kotlin("kapt") version "1.3.21"

    id("com.github.johnrengelman.shadow") version "5.0.0"
    // gradle dependencyUpdates -Drevision=release
    id("com.github.ben-manes.versions") version "0.21.0"
    id("com.palantir.docker") version "0.21.0"
}

repositories {
    jcenter()
}

val kotlinLoggingVer = "1.6.25"
val log4jVer = "2.11.2"
val slf4jVer = "1.7.25"

val daggerVer = "2.17"

val junitJupiterVer = "5.4.1"

dependencies {
    implementation(kotlin("stdlib-jdk8"))
//    implementation(kotlin("reflect"))

    implementation("io.github.microutils:kotlin-logging:$kotlinLoggingVer")

    implementation("com.google.dagger:dagger:$daggerVer")
    kapt("com.google.dagger:dagger-compiler:$daggerVer")

    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVer")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVer")
}

application {
    mainClassName = "app.AppKt"
    applicationName = "app"
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

idea {
    project {
        languageLevel = IdeaLanguageLevel(JavaVersion.VERSION_11)
    }
    module {
        isDownloadJavadoc = true
        isDownloadSources = true
    }
}

tasks {
    withType(KotlinCompile::class).configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
            freeCompilerArgs = listOf("-progressive")
        }
    }

    withType(JavaCompile::class).configureEach {
        options.isFork = true
    }

    withType(Test::class).configureEach {
        maxParallelForks =
            (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 }
                ?: 1

        useJUnitPlatform()
        testLogging {
            events = setOf(
                TestLogEvent.PASSED,
                TestLogEvent.SKIPPED,
                TestLogEvent.FAILED
            )
        }

        reports.html.isEnabled = false
    }

    wrapper {
        gradleVersion = "5.2.1"
        distributionType = Wrapper.DistributionType.ALL
    }

    shadowJar {
        archiveBaseName.set("app")
        archiveClassifier.set("")
    }

    build { dependsOn("shadowJar") }
}

