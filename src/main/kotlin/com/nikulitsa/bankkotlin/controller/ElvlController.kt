package com.nikulitsa.bankkotlin.controller

import com.nikulitsa.bankkotlin.entity.Elvl
import com.nikulitsa.bankkotlin.service.ElvlService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/elvl")
class ElvlController(private val service: ElvlService) {

    @GetMapping("/{isin}")
    fun getByIsin(@PathVariable isin: String): Elvl {
        return service.getByIsin(isin)
    }

    @GetMapping("/all")
    fun getAll(): List<Elvl> {
        return service.getAll()
    }
}