package com.nikulitsa.bankkotlin.service

import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class QuotesQueueListener(
    private val elvlService: ElvlService,
    private val quotesQueue: QuotesQueue
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        while (true) {
            try {
                val polledQuote = quotesQueue.poll()
                polledQuote?.let(elvlService::refreshElvl)
            } catch (e: Exception) {
                log.error(e.message, e)
            }
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(QuotesQueueListener::class.java)
    }
}