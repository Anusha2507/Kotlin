package com.axis.springlearn.controller

import com.axis.springlearn.model.Student
import com.axis.springlearn.service.StudentService
import com.axis.springlearn.service.StudentServiceTwo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.hateoas.EntityModel
import org.springframework.hateoas.Link
import org.springframework.hateoas.server.core.DummyInvocationUtils.methodOn
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.lang.reflect.Array.get
import java.util.*
import javax.validation.Valid

@RestController
class StudentController2(
    @Autowired val studentService: StudentServiceTwo,
    @Autowired val messageSource:MessageSource) {


    //    @RequestMapping(method = arrayOf(RequestMethod.GET))
    @GetMapping("/helloworld", produces = ["application/xml"])
     fun helloWorld(@RequestHeader(name = "Accept-Language", required = false)locale: Locale) : String? {
       return messageSource.getMessage("com.axis.key.helloworld",null,"Welcome default",locale) }

//    @GetMapping("/path/{id}")
//    fun getPathVariable(@PathVariable id: Int): String {
//        return "Received path variable $id"
//    }

//    @GetMapping("/student/{id}")
//    fun getStudent(@PathVariable id: Int): ResponseEntity<Student> {
//        val student = studentService.findOne(id)
//        if(student == null){
//            ResponseEntity<Student>(HttpStatus.NOT_FOUND)
//        }
//        return ResponseEntity<Student>(student,HttpStatus.OK)
//    }

//    @GetMapping("/student/{id}")
//    fun getStudent(@PathVariable id: Int): EntityModel<Optional<Student>> {
//        val student = studentService.retrieveStudent(id)
//        val model =EntityModel.of(student)
//        val link = Link.of("https://localhost:8080/users")
//        model.add(link)
//        return model
//
//    }
    @GetMapping("/student/{id}")
    fun getStudent(@PathVariable id: Int): Student {
        val student = studentService.retrieveStudent(id)
        //val model =EntityModel.of(student)
        //val link = Link.of("https://localhost:8080/users")
        val link = WebMvcLinkBuilder.linkTo(
            methodOn(this.javaClass).getStudents()).withRel("LinkRelation")
        return student.get().add(link)
    }

    @GetMapping("/students")
    fun getStudents(): List<Student> {
        return studentService.retrieveAllStudents()
    }

    //Adding student
    @PostMapping("/student")
    fun addStudent(@Valid @RequestBody student: Student):Student{
        return studentService.add(student)
    }

    //delete student
    @DeleteMapping("/student/{id}")
    fun  deleteStudent(@PathVariable id:Int) {
        return studentService.removeStudent(id)
    }

    //Edit Student
    @PutMapping("/student")
    fun editStudent(@RequestBody student: Student): Student {
        return studentService.save(student)
    }
}