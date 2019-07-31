package com.nikulitsa.bankkotlin.controller

import com.nikulitsa.bankkotlin.entity.Quote
import com.nikulitsa.bankkotlin.service.QuoteService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/quote")
class QuoteController(val quoteService: QuoteService) {

    @PostMapping
    fun save(@RequestBody quote: Quote): Quote {
        return quoteService.save(quote)
    }
}