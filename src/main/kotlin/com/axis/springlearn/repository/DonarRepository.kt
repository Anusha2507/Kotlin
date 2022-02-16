package com.axis.springlearn.repository

import com.axis.springlearn.model.Donar
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DonarRepository:JpaRepository<Donar,Int> {
}