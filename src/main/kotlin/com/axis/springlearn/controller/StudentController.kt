package com.axis.springlearn.controller

import com.axis.springlearn.model.Student
import com.axis.springlearn.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController(@Autowired val studentService: StudentService) {

    //    @RequestMapping(method = arrayOf(RequestMethod.GET))
//    @GetMapping("/hello")
//    fun helloWorld(): String {
//        return "hello world !!!"
//    }
//
//    @GetMapping("/path/{id}")
//    fun getPathVariable(@PathVariable id: Int): String {
//        return "Received path variable $id"
//    }
//
////    @GetMapping("/student/{id}")
////    fun getStudent(@PathVariable id: Int): ResponseEntity<Student> {
////        val student = studentService.findOne(id)
////        if(student == null){
////            ResponseEntity<Student>(HttpStatus.NOT_FOUND)
////        }
////        return ResponseEntity<Student>(student,HttpStatus.OK)
////    }
//
//    @GetMapping("/student/{id}")
//    fun getStudent(@PathVariable id: Int): Student? {
//        println("start")
//        val student = studentService.findOne(id)
//        println("end")
//        return student
//    }
//
//    @GetMapping("/students")
//    fun getStudents(): MutableList<Student> {
//        return studentService.findAll()
//    }
//
//    //    @GetMapping("/save")
////    fun saveStudent(): Boolean {
////        val student5: Student = Student(5, "rohini", "female", "rohini@gmial.com", 97501)
////        return studentService.save(student5)
////    }
//
//    //Adding student
//    @PostMapping("/student")
//    fun addStudent(@RequestBody student: Student): Boolean {
//        return studentService.saveOrUpdate(student)
//    }
//
//    //delete student
//    @DeleteMapping("/student/{id}")
//    fun  deleteStudent(@PathVariable id:Int):String?{
//        return studentService.delete(id)
//    }
//
//    //Edit Student
//    @PutMapping("/student")
//    fun editStudent(@RequestBody student: Student):Boolean{
//        return studentService.saveOrUpdate(student)
//    }

}