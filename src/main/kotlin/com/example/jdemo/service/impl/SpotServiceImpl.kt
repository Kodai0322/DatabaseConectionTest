package com.example.jdemo.service.impl

import com.example.jdemo.entity.Spot
import com.example.jdemo.repository.SpotRepository
import com.example.jdemo.service.SpotService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SpotServiceImpl(
        private val repository:SpotRepository):SpotService{

    @Transactional(readOnly = true)
    override fun findByID(id: Long): Spot? =
            repository.findById(id).orElse(null)

    @Transactional(readOnly = true)
    override fun findAll(page: Pageable): List<Spot> =
            repository.findAll(page).content

    @Transactional(timeout = 10)
    override fun store(spot: Spot) {
        repository.save(spot)
    }

    @Transactional(timeout = 10)
    override fun remove(id: Long) {
        repository.deleteById(id)
    }
}