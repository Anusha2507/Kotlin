package com.axis.springlearn.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
@Entity
data class Blood(
    @Id
    var bloodType:String,
    @GeneratedValue
    var bloodBagNumber:Int,
    var bloodCode:Int
)
