package com.nikulitsa.bankkotlin.controller

import com.nikulitsa.bankkotlin.entity.Quote
import com.nikulitsa.bankkotlin.service.QuoteService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/quote")
class QuoteController(val quoteService: QuoteService) {

    @PostMapping
    fun save(@Valid @RequestBody quote: Quote): Quote = quoteService.save(quote)
}
