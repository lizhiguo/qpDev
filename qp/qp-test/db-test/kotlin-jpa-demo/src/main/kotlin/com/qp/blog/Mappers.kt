package com.qp.blog

import jakarta.persistence.EntityNotFoundException
import org.mapstruct.*
import org.springframework.beans.factory.annotation.Autowired

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
abstract class UserMapper {
    @Autowired
    private lateinit var departmentRepository: DepartmentRepository

    @Mappings(
        Mapping(source = "departmentId", target = "department", qualifiedByName = ["getDepartment"]),
    )
    abstract fun fromUserDtoToUser(userDto: UserDto): AppUser

    @Named("getDepartment")
    fun getDepartment(departmentId: String): Department {
        return this.departmentRepository.findById(departmentId).orElseThrow {
            throw EntityNotFoundException("Unable to find department with id $departmentId")
        }
    }
}