package com.nikulitsa.bankkotlin.service

import com.nikulitsa.bankkotlin.config.QuotesQueueListenerThreadPoolConfig.Companion.QUOTES_QUEUE_LISTENER_THREAD_POOL
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import java.util.concurrent.atomic.AtomicBoolean

@Component
class QuotesQueueListener(
    private val elvlService: ElvlService,
    private val quotesQueue: QuotesQueue
) {

    private val listen = AtomicBoolean(true)

    @EventListener(ApplicationReadyEvent::class)
    @Async(QUOTES_QUEUE_LISTENER_THREAD_POOL)
    fun run() {
        while (listen.get()) {
            try {
                val polledQuote = quotesQueue.poll()
                polledQuote?.let(elvlService::refreshElvl)
            } catch (e: Exception) {
                log.error(e.message, e)
            }
        }
    }

    @EventListener(ContextClosedEvent::class)
    fun stop() {
        listen.set(false)
    }

    companion object {
        private val log = LoggerFactory.getLogger(QuotesQueueListener::class.java)
    }
}
