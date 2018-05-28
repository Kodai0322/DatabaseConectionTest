package com.example.jdemo.service

import com.example.jdemo.entity.Spot
import org.springframework.data.domain.Pageable


interface SpotService{
    fun findByID(id: Long): Spot?
    fun findAll(page: Pageable): List<Spot>
    fun store(spot: Spot)
    fun remove(id: Long)
}