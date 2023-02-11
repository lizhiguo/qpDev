plugins {
    kotlin("jvm")
    `java-library`
}
dependencies {
    //引入依赖版本统一管理模块
    implementation(platform(project(":qp-bom")))
    implementation("cn.hutool:hutool-all")
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}