package com.axis.springlearn.service

import com.axis.springlearn.exception.StudentNotFoundException
import com.axis.springlearn.model.Student
import org.springframework.stereotype.Service

@Service
class StudentService {
    val students = mutableListOf<Student>(
        Student(1, "Anusha", "female", "anu@gmial.com", 826296),
        Student(2, "nandini", "female", "giri@gmial.com", 8292962),
        Student(3, "panini", "female", "p-av@gmial.com", 896962968433)
    )

    fun findOne(id: Int): Student {
        for (student in students) {
            if (student.id == id) {
                return student
            }
        }
        throw StudentNotFoundException("Student not found")
    }

    fun findAll(): MutableList<Student> {
        return students
    }

    fun saveOrUpdate(student: Student): Boolean {
//        if(findOne(student.id) == student){
//            students.remove(student)
//        }
        for (stud in students){
            if(stud == student){
                students.remove(student)
            }
        }
        return students.add(student)
    }

    fun delete(id: Int): String? {
        for (student in students) {
            if (student.id == id) {
                students.remove(student)
                return "Deleted Successfully"
            }
        }
        return null
    }
}
