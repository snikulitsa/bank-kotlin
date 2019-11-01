package com.nikulitsa.bankkotlin.entity

import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "energy_level")
data class Elvl(
    @Id
    val isin: String,
    val elvl: BigDecimal
)
