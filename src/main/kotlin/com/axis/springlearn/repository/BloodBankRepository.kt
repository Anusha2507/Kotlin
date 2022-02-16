package com.axis.springlearn.repository

import com.axis.springlearn.model.BloodBank
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BloodBankRepository : JpaRepository<BloodBank,String>{



}