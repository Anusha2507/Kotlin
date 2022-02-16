package com.axis.springlearn.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Employee(
    @Id
    @GeneratedValue
    var empId:Int,
    var empName:String,
    var empBranch:String,
    var empRole:String,
    var empSalary:Int)
