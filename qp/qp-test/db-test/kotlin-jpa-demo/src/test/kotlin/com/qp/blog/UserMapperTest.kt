package com.qp.blog

import jakarta.persistence.EntityNotFoundException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
internal class UserMapperTest @Autowired constructor(
    private val userMapper: UserMapper
){
    @Test
    fun `数据保存`(){

    }
    @Test
    fun `should convert dto to entity if department is valid`(){
        //given
        val dto = UserDto("3LexW", "DEPT_A")

        //when
        val entity = userMapper.fromUserDtoToUser(dto)

        //then
        val actualValue = AppUser(null, "3LexW", Department("DEPT_A", "Department A"))

        assertEquals(actualValue, entity)
    }

    @Test
    fun `should throw error if department is not valid`(){
        //given
        val dto = UserDto("3LexW", "UNKNOWN")

        //when / then
        assertThrows<EntityNotFoundException> {
            val entity = userMapper.fromUserDtoToUser(dto)
        }
    }
}