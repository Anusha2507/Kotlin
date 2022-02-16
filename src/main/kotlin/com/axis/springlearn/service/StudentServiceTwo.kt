package com.axis.springlearn.service

import com.axis.springlearn.model.Student
import com.axis.springlearn.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudentServiceTwo(@Autowired val studentRepository: StudentRepository ) {

    fun add(student: Student): Student {
       return studentRepository.save(student)
    }

    fun retrieveAllStudents(): List<Student> {
        return studentRepository.findAll()
    }

    fun retrieveStudent(id: Int): Optional<Student> {
        return studentRepository.findById(id)
    }

    fun removeStudent(id: Int) {
        return studentRepository.deleteById(id)
    }

    fun save(student: Student): Student {
        return studentRepository.save(student)
    }

}