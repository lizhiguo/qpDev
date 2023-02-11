import io.spring.gradle.dependencymanagement.internal.DependencyManagement
import org.gradle.internal.impldep.org.eclipse.jgit.lib.ObjectChecker.encoding
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    val kotlinVersion = "1.7.22"
    id("org.springframework.boot") version "3.0.2"  apply false
    id("io.spring.dependency-management") version "1.1.0"
//    id("org.asciidoctor.convert") version "1.5.8"  apply false
    kotlin("jvm") version kotlinVersion  apply false
    kotlin("plugin.spring") version kotlinVersion  apply false
    kotlin("plugin.jpa") version kotlinVersion  apply false
//    kotlin("plugin.serialization") version kotlinVersion  apply false
    kotlin("kapt") version kotlinVersion apply false
    id("io.freefair.lombok") version "6.6.1" apply false

}
allprojects {
    group = "com.qp"
    version = "1.0.0"

    tasks.withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
        options.encoding = "UTF-8"
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }
}

subprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    /*apply {
        plugin("io.spring.dependency-management")
        plugin("org.springframework.boot")
    }*/
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    dependencyManagement {
        imports {
            mavenBom("com.qp:qp-bom:${project.version}")
        }
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }

}
tasks.forEach { // 禁止根项目构建
    it.enabled = false
}

fun Project.hasSubProjects() = subprojects.isNotEmpty()
fun Project.isBomProject() = name.endsWith("bom")
