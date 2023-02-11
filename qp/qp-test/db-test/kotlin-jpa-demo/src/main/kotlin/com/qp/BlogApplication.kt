package com.qp


import com.qp.blog.BlogProperties
import com.qp.blog.User
import com.qp.common.event.annotation.HibernateEventListener
import org.hibernate.event.spi.PreInsertEvent
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(BlogProperties::class)
class BlogApplication{

	@HibernateEventListener
	fun handlePreInsert(entity: User, event: PreInsertEvent){
		println("获得数据:${entity.id}")
	}
}

fun main(args: Array<String>) {
	runApplication<BlogApplication>(*args)
}
