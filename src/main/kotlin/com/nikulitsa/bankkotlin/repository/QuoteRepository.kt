package com.nikulitsa.bankkotlin.repository

import com.nikulitsa.bankkotlin.entity.Quote
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QuoteRepository : JpaRepository<Quote, Long>