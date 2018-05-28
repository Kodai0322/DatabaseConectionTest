package com.example.jdemo.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name="spot")
data class Spot(
  @Column(name="title",nullable = false)
  var title:String = "",
  @Column(name="subtitle",nullable = false)
  var subtitle:String = "",
  @Column(name = "area",nullable = false)
  var area:String = "",
  @Column(name = "lat",nullable = false)
  var lat:Double = -1.0,
  @Column(name = "lng",nullable = false)
  var lng:Double = -1.0,
  @Column(name="explanation",nullable = true)
  var explanation:String = "",
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var id:Long = 0
):Serializable