package com.nikulitsa.bankkotlin.entity

import com.nikulitsa.bankkotlin.entity.validation.BidLessThanAskCheck
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Size

@Entity
@Table(name = "quote")
@BidLessThanAskCheck
data class Quote(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @Size(min = 12, max = 12)
    val isin: String,
    val bid: BigDecimal?,
    val ask: BigDecimal,
    val bidSize: Long,
    val askSize: Long
)