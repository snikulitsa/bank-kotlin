package com.nikulitsa.bankkotlin.service

import com.nikulitsa.bankkotlin.entity.Quote
import com.nikulitsa.bankkotlin.repository.QuoteRepository
import org.springframework.stereotype.Service

@Service
class QuoteServiceImpl(val repository: QuoteRepository): QuoteService {

    override fun save(quote: Quote): Quote {
        return repository.save(quote);
    }
}