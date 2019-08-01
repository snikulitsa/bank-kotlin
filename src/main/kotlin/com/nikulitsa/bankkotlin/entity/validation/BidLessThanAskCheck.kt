package com.nikulitsa.bankkotlin.entity.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.reflect.KClass

@Retention(RUNTIME)
@Constraint(validatedBy = [QuoteValidator::class])
annotation class BidLessThanAskCheck(
    val message: String = "'bid' must be less than 'ask' or NULL.",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)