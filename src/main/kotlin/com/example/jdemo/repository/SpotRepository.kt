package com.example.jdemo.repository

import com.example.jdemo.entity.Spot
import org.springframework.data.jpa.repository.JpaRepository

interface  SpotRepository:JpaRepository<Spot,Long>