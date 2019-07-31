package com.nikulitsa.bankkotlin.service

import com.nikulitsa.bankkotlin.entity.Quote

interface QuoteService {

    fun save(quote: Quote): Quote
}