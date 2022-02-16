package com.axis.springlearn.controller

import com.axis.springlearn.model.Employee
import com.axis.springlearn.service.EmployeeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class EmployeeController (@Autowired val employeeService :EmployeeService){
    //Get Employee using id
    @GetMapping("/employee/{id}")
    fun getEmployee(@PathVariable id:Int):Employee?{
        return employeeService.retrieveEmployee(id)
    }
//    //Get Employee using name
//    @GetMapping("/employee/{name}")
//    fun getEmployee(@PathVariable name:String):Employee?{
//        return employeeService.getOne(name)
//    }
    //Get all employees
    @GetMapping("/employees")
    fun getEmployees(): List<Employee> {
        return employeeService.retrieveAllEmployees()
    }
//
    //post an employee if not there or else replacing
    @PostMapping("/employee")
    fun postEmployee(@RequestBody employee:Employee): Employee {
        return employeeService.add(employee)
    }
    @PutMapping("/employee")
    fun editEmployee(@RequestBody employee:Employee): Employee {
        return employeeService.edit(employee)
    }

    //Deleting an employee
    @DeleteMapping("/employee/{id}")
    fun deleteEmployee(@PathVariable id:Int) {
        return employeeService.deleteEmployee(id)
    }
//    @DeleteMapping("/employee/{name}")
//    fun deleteEmployee(@PathVariable name:String):String?{
//        return employeeService.deleteEmployee(name)
//    }

}