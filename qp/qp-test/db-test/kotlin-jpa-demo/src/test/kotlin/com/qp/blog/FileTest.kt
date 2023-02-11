package com.qp.blog

import cn.hutool.core.util.StrUtil
import org.junit.jupiter.api.Test
import java.io.File

val file = File("C:\\mywork\\myDev\\jvmDev\\projectDev\\testDev\\qp-test\\kotlin-jpa-demo\\src\\test\\kotlin\\com\\qp\\blog\\12.24log.txt")

class FileTest {

    @Test
    fun testRead(){
        println("forEachLine-------------------->")
        file.bufferedReader().use {
            it.readLines()
                .filter  {StrUtil.contains(it,"user") }
                .filter  {StrUtil.contains(it,"login successfully")}
                .forEach(::println)
        }
    }
}