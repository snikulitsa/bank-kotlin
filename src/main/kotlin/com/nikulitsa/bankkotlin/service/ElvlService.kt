package com.nikulitsa.bankkotlin.service

import com.nikulitsa.bankkotlin.entity.Elvl
import com.nikulitsa.bankkotlin.entity.Quote

interface ElvlService {

    fun refreshElvl(quote: Quote): Elvl

    fun getByIsin(isin: String): Elvl

    fun getAll(): List<Elvl>
}