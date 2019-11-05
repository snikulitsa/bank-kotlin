package com.nikulitsa.bankkotlin.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

@Configuration
class QuotesQueueListenerThreadPoolConfig {

    @Bean(QUOTES_QUEUE_LISTENER_THREAD_POOL)
    fun quotesQueueListenerThreadPool() = ThreadPoolTaskExecutor().apply {
        corePoolSize = POOL_SIZE
        maxPoolSize = POOL_SIZE
    }

    companion object {
        const val QUOTES_QUEUE_LISTENER_THREAD_POOL = "quotesQueueListenerThreadPool"
        const val POOL_SIZE = 1
    }
}
