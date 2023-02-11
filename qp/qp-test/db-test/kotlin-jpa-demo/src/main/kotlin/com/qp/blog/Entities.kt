package com.qp.blog


import io.hypersistence.utils.hibernate.type.json.JsonType
import jakarta.persistence.*
import org.hibernate.annotations.Type
import java.time.LocalDateTime


@Entity
class Article(
	var title: String,
	var headline: String,
	var content: String,
	@ManyToOne var author: User,
	var slug: String = title.toSlug(),
	var addedAt: LocalDateTime = LocalDateTime.now(),
	@Id @GeneratedValue var id: Long? = null) {
}

@Entity
class User(
		var login: String,
		var firstname: String,
		var lastname: String,
		var description: String? = null,
		@Type(JsonType::class)
		@Column(columnDefinition = "json")
		var extJson1: Map<String, String>? = null,
		@Id @GeneratedValue var id: Long? = null)

@Entity
data class AppUser (
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	val id: Long? = null,

	@Column(unique = true)
	val username: String,

	@ManyToOne
	val department: Department,
)
@Entity
data class Department (
	@Id
	@Column
	val departmentId: String,

	@Column
	val departmentName: String
)

