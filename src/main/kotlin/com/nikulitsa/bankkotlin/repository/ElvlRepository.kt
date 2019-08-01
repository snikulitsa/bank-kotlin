package com.nikulitsa.bankkotlin.repository

import com.nikulitsa.bankkotlin.entity.Elvl
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ElvlRepository: JpaRepository<Elvl, String> {
    fun findByIsin(isin: String): Elvl?
}