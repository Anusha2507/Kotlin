package com.axis.springlearn.model

import org.springframework.hateoas.RepresentationModel
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Entity
data class Student(
    @Id
    @GeneratedValue
    var id: Int,
    @get: Size(min =3,max=10)
    var name: String,
    @get : NotBlank
    var gender: String,
    @get:Email(message = "Invalid email")
    var email: String,
    @get: Pattern(regexp = "^[0-9]{10}")
    var phone: Long
) : RepresentationModel<Student>()
