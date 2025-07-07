package com.learning.pet_tracker_api.model


data class Pet(
    val id: Int = 0,  // Will be auto-generated
    val name: String,
    val type: String
)