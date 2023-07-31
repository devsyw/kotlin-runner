import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.2"
    id("io.spring.dependency-management") version "1.1.2"
    kotlin("jvm") version "1.8.22" // 플러그인은 프로젝트에서 사용할 Kotlin 버전을 정의합니다.
    kotlin("plugin.spring") version "1.8.22" // Kotlin 클래스가 Spring Framework 기능과 호환되도록 하기 위해 수정자를 추가하기 위한 Kotlin Spring 컴파일러 플러그인
    kotlin("plugin.jpa") version "1.8.22"
}

group = "com.urizip"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin") // 이 모듈은 Kotlin 클래스 및 데이터 클래스의 직렬화 및 역직렬화 지원을 추가합니다.
    implementation("org.jetbrains.kotlin:kotlin-reflect") // 코틀린 리플렉션 라이브러리
    runtimeOnly("com.h2database:h2")
    testImplementation(kotlin("test")) // test lib
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
