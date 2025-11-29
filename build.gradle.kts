plugins {
	java
	id("org.springframework.boot") version "3.5.7"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.codeonblue"
version = "1.0.0"
description = "API for managing budgets"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

repositories {
	mavenCentral()
}

dependencies {

    // Web
	implementation("org.springframework.boot:spring-boot-starter-web")

    // ULID generation
    implementation("de.huxhorn.sulky:de.huxhorn.sulky.ulid:8.2.0")

    // Database
    implementation("com.google.firebase:firebase-admin:9.7.0")
    
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
