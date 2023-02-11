package com.qp.biz.emp.http

import cn.hutool.core.lang.Console
import cn.hutool.http.HttpRequest
import org.junit.jupiter.api.Test

class Gz {
    @Test
    fun `资产管理类别查询`(){
        var json = """
            {}
        """.trimIndent()
        var result = ospost("http://192.168.12.119:50000/RESTAdapter/OA/ZC01",json)
        Console.log(result)
    }
    @Test
    fun `资产管理归属查询`(){
        var json = """
            {}
        """.trimIndent()
        var result = ospost("http://192.168.12.119:50000/RESTAdapter/OA/ZC02",json)
        Console.log(result)
    }

    fun ospost( url : String, body : String):String {
        var result = HttpRequest.post("http://192.168.12.119:50000/RESTAdapter/OA/ZC02")
            .auth("Basic UE9fT0FfVVNFUjpxaXBhaTE5Nzk=")
            .body(body)
            .execute().body()
        return result
    }
}