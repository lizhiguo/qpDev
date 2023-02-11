plugins {
    `java-platform`
    `maven-publish`
}

javaPlatform {
    allowDependencies()
}
dependencies {
    val springbootVersion = "3.0.2"
    val jetcacheVersion = "2.7.1" //redis库
    val hutoolVersion = "5.8.10"  //工具库
    val mapstructVersion = "1.5.3.Final" //数据映射库
    val swaggerVersion = "2.2.7"
    val opendocVersion = "1.6.13"
    val p6spyVersion = "3.9.1"
    val weixinVersion = "4.4.5.B"
    val hypersistenceVersion = "3.1.1" //ormd对应json数据类型操作库
    val hypersistenceOptimizerVersion = "2.6.3" //jpa和hibernate性能分析工具
    val jdslVersion = "2.2.0.RELEASE" //orm操作

    api(platform("org.springframework.boot:spring-boot-dependencies:${springbootVersion}"))
    api(platform("org.springdoc:springdoc-openapi:${opendocVersion}"))
    constraints {
        // 常用boot-starter
        api("com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.8.1")
        api("com.baomidou:mybatis-plus-boot-starter:3.5.2")
        api("com.github.pagehelper:pagehelper-spring-boot-starter:1.4.6")


        api("com.alicp.jetcache:jetcache-starter-redis-lettuce:${jetcacheVersion}")
        api("com.alicp.jetcache:jetcache-starter-redis:${jetcacheVersion}")
        api("com.alicp.jetcache:jetcache-starter-redis-springdata:${jetcacheVersion}")

        // 数据库操作
        api("io.hypersistence:hypersistence-utils-hibernate-60:${hypersistenceVersion}")
//        api("io.hypersistence:hypersistence-optimizer:${hypersistenceOptimizerVersion}")
        api("org.mybatis:mybatis-spring:3.0.0")
        api("org.mybatis:mybatis:3.5.11")
        // jsdl
        api("com.linecorp.kotlin-jdsl:spring-data-kotlin-jdsl-reactive-core-jakarta:${jdslVersion}")
        api("com.linecorp.kotlin-jdsl:spring-data-kotlin-jdsl-hibernate-reactive-jakarta:${jdslVersion}")
        api("com.linecorp.kotlin-jdsl:spring-data-kotlin-jdsl-starter-jakarta:${jdslVersion}")

        // 常用工具
        api("cn.hutool:hutool-all:${hutoolVersion}")
        api("com.google.guava:guava:31.1-jre")
        // 阿里工具
        api("com.alicp.jetcache:jetcache-redis:${jetcacheVersion}")
        api("com.alicp.jetcache:jetcache-redis-lettuce:${jetcacheVersion}")
        api("com.alicp.jetcache:jetcache-anno:${jetcacheVersion}")
        api("com.alicp.jetcache:jetcache-redis-springdata:${jetcacheVersion}")
        // 编译工具
        api("org.mapstruct:mapstruct:${mapstructVersion}")
        api("org.mapstruct:mapstruct-processor:${mapstructVersion}")
        api("org.javassist:javassist:3.29.2-GA")
        // 接口文档工具
        api("io.swagger.core.v3:swagger-annotations:${swaggerVersion}")
        // 日志
        api("p6spy:p6spy:${p6spyVersion}")
        // 微信
        // 企业微信
        api("com.github.binarywang:weixin-java-cp:${weixinVersion}")
        // 公众号
        api("com.github.binarywang:weixin-java-mp:${weixinVersion}")
        // jwt
        // 测试
        api("org.glassfish:jakarta.el:5.0.0-M1")
        api("com.github.jsonzou:jmockdata:4.3.0")
        api("com.ninja-squad:springmockk:3.1.2")
        // 其它
        api("jakarta.el:jakarta.el-api:5.0.1")


    }
}
publishing {
    repositories {
        var nexusUrl = "https://sn.qipai.com.cn/nexus/content/repositories/releases/"
        if (project.version.toString().endsWith("SNAPSHOT")) {
            nexusUrl = "https://sn.qipai.com.cn/nexus/content/repositories/snapshots/"
        }
        maven {
            url = uri(nexusUrl)
            credentials {
                username = "admin"
                password = "admin123"
            }
        }
    }
    publications {
        create<MavenPublication>("myPlatform") {
            from(components["javaPlatform"])
        }
    }
}