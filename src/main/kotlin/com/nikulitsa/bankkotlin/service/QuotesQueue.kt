package com.nikulitsa.bankkotlin.service

import com.nikulitsa.bankkotlin.entity.Quote
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentLinkedQueue

@Component
class QuotesQueue(
        private val queue: ConcurrentLinkedQueue<Quote> = ConcurrentLinkedQueue()
) {

    fun add(quote: Quote) {
        queue.add(quote)
    }

    fun poll(): Quote? {
        return queue.poll()
    }
}