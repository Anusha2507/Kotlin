package com.axis.springlearn.repository

import com.axis.springlearn.model.Blood
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BloodRepository:JpaRepository<Blood,Int> {
}