package com.example.jdemo.controller

import com.example.jdemo.entity.Spot
import com.example.jdemo.service.SpotService
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["spot"])
class SpotController(
    private val service: SpotService){

    //private val log = LoggerFactory.getLogger(SpotController::class.java)

    @GetMapping(path = ["{id}"],produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun id(@PathVariable(value = "id")id:Long):ResponseEntity<Spot>{
        val spot = service.findByID(id)
        return if(spot != null){
            ResponseEntity.ok(spot)
        }else{
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
    @GetMapping(path = ["list"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun list(page: Pageable): ResponseEntity<List<Spot>> {
        return ResponseEntity.ok(service.findAll(page))
    }

    @PostMapping(produces = [MediaType.TEXT_PLAIN_VALUE], consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun store(@RequestBody spot: Spot): ResponseEntity<String> {
        service.store(spot)
        return ResponseEntity.ok("success")
    }

    @DeleteMapping(path = ["{id}"], produces = [MediaType.TEXT_PLAIN_VALUE])
    fun remove(@PathVariable(value = "id") id: Long): ResponseEntity<String> {
        service.remove(id)
        return ResponseEntity.ok("success")
    }
}