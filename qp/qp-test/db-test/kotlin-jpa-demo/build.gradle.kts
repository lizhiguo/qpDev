import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

description = "数据库操作测试模块"
plugins {
    java
    kotlin("jvm")
//    `java-library`
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
//    id("io.freefair.lombok")
//    id("org.springframework.boot")
//    id("io.spring.dependency-management")

    kotlin("kapt")
    idea
}

dependencies {
    //引入依赖版本统一管理模块
//    implementation(platform(project(":qp-bom")))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-mustache")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("io.hypersistence:hypersistence-utils-hibernate-60")
    implementation("org.hibernate.orm:hibernate-envers")
    implementation("com.linecorp.kotlin-jdsl:spring-data-kotlin-jdsl-starter-jakarta")
    implementation("org.mybatis:mybatis")
    implementation("cn.hutool:hutool-all")
    implementation("org.mapstruct:mapstruct:1.5.2.Final")
    kapt("org.mapstruct:mapstruct-processor")
    compileOnly("io.swagger.core.v3:swagger-annotations")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    runtimeOnly("com.mysql:mysql-connector-j")
    runtimeOnly("org.springframework.boot:spring-boot-devtools")
//    kapt("org.springframework.boot:spring-boot-configuration-processor")
    testCompileOnly("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.ninja-squad:springmockk")
    testAnnotationProcessor("org.projectlombok:lombok")

}
configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}
allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.Embeddable")
    annotation("jakarta.persistence.MappedSuperclass")
}
noArg {
    annotation("jakarta.persistence.Entity")
}

/*
idea {
    module {
        val kaptMain = file("build/generated/source/kapt/main")
        sourceDirs.add(kaptMain)
        generatedSourceDirs.add(kaptMain)
    }
}*/
