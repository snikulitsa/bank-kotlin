package com.nikulitsa.bankkotlin.entity.validation

import com.nikulitsa.bankkotlin.entity.Quote
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class QuoteValidator: ConstraintValidator<BidLessThanAskCheck, Quote> {
    override fun isValid(quote: Quote, context: ConstraintValidatorContext?): Boolean {
        val bid = quote.bid
        val ask = quote.ask
        if (bid != null) {
            return bid < ask
        }
        return true
    }
}