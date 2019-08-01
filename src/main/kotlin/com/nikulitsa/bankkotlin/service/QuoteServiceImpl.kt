package com.nikulitsa.bankkotlin.service

import com.nikulitsa.bankkotlin.entity.Quote
import com.nikulitsa.bankkotlin.repository.QuoteRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QuoteServiceImpl(
    private val repository: QuoteRepository,
    private val quotesQueue: QuotesQueue
) : QuoteService {

    @Transactional
    override fun save(quote: Quote): Quote {
        val savedQuote = repository.save(quote)
        quotesQueue.add(savedQuote)
        return savedQuote
    }
}