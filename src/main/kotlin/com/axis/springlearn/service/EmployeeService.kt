package com.axis.springlearn.service

import com.axis.springlearn.exception.EmployeeExceptions
import com.axis.springlearn.model.Employee
import com.axis.springlearn.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EmployeeService(@Autowired val employeeRepository: EmployeeRepository) {
    fun add(employee: Employee): Employee {
        return employeeRepository.save(employee)
    }

    fun retrieveEmployee(id: Int): Employee? {
        return employeeRepository.getById(id)
    }

    fun retrieveAllEmployees(): List<Employee> {
        return employeeRepository.findAll()
    }

    fun deleteEmployee(id: Int) {
        return employeeRepository.deleteById(id)
    }

    fun edit(employee: Employee): Employee {
        return employeeRepository.save(employee)
    }


}