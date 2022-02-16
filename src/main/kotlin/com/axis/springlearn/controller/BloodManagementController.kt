package com.axis.springlearn.controller

import com.axis.springlearn.model.Blood
import com.axis.springlearn.model.Donar
import com.axis.springlearn.service.BloodManagementService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class BloodManagementController (@Autowired val bloodManagementService: BloodManagementService){
    @PostMapping("/donar")
    fun addDonar(@RequestBody donar: Donar):Donar{

        return bloodManagementService.add(donar)
    }

    @GetMapping("/donar/{id}")
    fun getDonar(@PathVariable id:Int): Optional<Donar> {
        return bloodManagementService.retrieveDonar(id)
    }
    @GetMapping("/donars")
    fun getAllDonars(): MutableList<Donar> {
        return bloodManagementService.retrieveAllDonars()
    }
    @GetMapping("/request/{bloodtype}")
    fun bloodAvailabilityByGrp(@PathVariable bloodtype:String): Boolean {
        return bloodManagementService.bloodAvailabilityByGrp(bloodtype)
    }

//    @GetMapping("/request/{bloodtype}/{city}")
//    fun bloodAvailabilityByCity(@PathVariable city:String,bloodtype: String): Boolean {
//        return bloodManagementService.bloodAvailabilityByCity(city,bloodtype)
//    }

}