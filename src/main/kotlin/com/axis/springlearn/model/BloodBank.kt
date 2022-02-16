package com.axis.springlearn.model

import org.springframework.data.jpa.repository.Query
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class BloodBank(
    @Id
    var bloodType:String,
    @GeneratedValue
    var bloodBagNumber:Int,
    var quantityOnHand:Int,
    var address:String

){



}