package com.qp.blog

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BlogApplicationTests(@Autowired val userRepository: UserRepository) {

	@Test
	fun contextLoads() {
		val juergen = User("springjuergen77", "Juergen77", "Hoeller77")
		userRepository.save(juergen)
	}
	@Test
	fun contextLoads_json() {
		val juergen = User("springjuergen77", "Juergen77", "Hoeller77")
		juergen.extJson1 = mapOf("name" to "lhl")
		userRepository.save(juergen)
	}
}
