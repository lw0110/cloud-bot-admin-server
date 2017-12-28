import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		mavenCentral()
		maven("https://repo.spring.io/milestone")
	}

	dependencies {
		classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.0.M7")
		classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.2")
	}
}

apply {
	plugin("org.springframework.boot")
	plugin("org.junit.platform.gradle.plugin")
}

plugins {
	val kotlinVersion = "1.2.10"
	id("org.jetbrains.kotlin.jvm") version kotlinVersion
	id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
	id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion
	id("io.spring.dependency-management") version "1.0.3.RELEASE"
}

version = "1.0.0-SNAPSHOT"

tasks {
	withType<KotlinCompile> {
		kotlinOptions {
			jvmTarget = "1.8"
			freeCompilerArgs = listOf("-Xjsr305=strict")
		}
	}
}

repositories {
	mavenCentral()
	maven("http://repo.spring.io/milestone")
}

dependencies {
	compile("org.springframework.boot:spring-boot-starter-web")
	compile("org.springframework.boot:spring-boot-starter-data-jpa")
	compile("com.h2database:h2")
	compile("org.jetbrains.kotlin:kotlin-stdlib")
	compile("org.jetbrains.kotlin:kotlin-reflect")
	compile("com.fasterxml.jackson.module:jackson-module-kotlin")

    // TESTING
	testCompile("org.springframework.boot:spring-boot-starter-test")
    testCompile("com.nhaarman.mockitokotlin2:mockito-kotlin:2.0.0-alpha02")
    testCompile("org.mockito:mockito-core:2.13.0")
}

