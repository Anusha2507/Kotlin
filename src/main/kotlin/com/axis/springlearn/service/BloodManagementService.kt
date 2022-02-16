package com.axis.springlearn.service

import com.axis.springlearn.model.Blood
import com.axis.springlearn.model.BloodBank
import com.axis.springlearn.model.Donar
import com.axis.springlearn.repository.BloodBankRepository
import com.axis.springlearn.repository.BloodRepository
import com.axis.springlearn.repository.DonarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class BloodManagementService(
    @Autowired val bloodRepository: BloodRepository,
    @Autowired val donarRepository: DonarRepository,
    @Autowired val bloodBankRepository: BloodBankRepository
) {


    fun add(donar: Donar): Donar {

        var blood:Blood = Blood(donar.donarbloodType,donar.donarid,donar.donarid)
        bloodRepository.save(blood)


        var bloodBank:BloodBank =BloodBank(donar.donarbloodType,blood.bloodBagNumber,donar.donatedQuantityMl,donar.donaraddress )
        bloodBankRepository.save(bloodBank)

        return donarRepository.save(donar)
    }

    fun retrieveDonar(id: Int): Optional<Donar> {
        return donarRepository.findById(id)
    }

    fun retrieveAllDonars(): MutableList<Donar> {
        return donarRepository.findAll()
    }

    fun bloodAvailability(bloodtype: String,city:String): Boolean {
        return bloodBankRepository.existsById(bloodtype)
    }

    fun bloodAvailabilityByGrp(bloodtype: String): Boolean {
        return bloodBankRepository.existsById(bloodtype)
    }

//    fun bloodAvailabilityByCity(city: String, bloodtype: String): Boolean {
//        return bloodBankRepository.existsByCity(city,bloodtype)
//    }


}