import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.0"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.4.10"
	kotlin("plugin.spring") version "1.4.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	//implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	//implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	runtimeOnly("mysql:mysql-connector-java")
	implementation("org.flywaydb:flyway-core")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.4")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

	//open-csv
//	implementation("com.opencsv:opencsv:5.2")

	//H2
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	runtimeOnly("com.h2database:h2")

	//junit4
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	//junit5
	testImplementation("org.springframework.boot:spring-boot-starter-test"){
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
	testImplementation("org.junit.jupiter:junit-jupiter-api")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
	//dbunit
	testImplementation("com.github.springtestdbunit:spring-test-dbunit:1.3.0")
	testImplementation("org.dbunit:dbunit:2.7.0")
	//DbSetup-kotlin
	testImplementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")//jreだとエラーで動かない
	testImplementation("org.jetbrains.kotlin:kotlin-reflect:1.4.10")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}