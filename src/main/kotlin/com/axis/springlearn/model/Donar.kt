package com.axis.springlearn.model

import java.util.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Donar(
    @Id
    @GeneratedValue
    var donarid:Int,
    var donarname:String,
    var donateddate:String,
    var donarcontact:Long,
    var donardob:String,
    var donarsex:String,
    var donaraddress:String,
    var donarbloodType:String,
    var donatedQuantityMl:Int

)