package com.learning.pet_tracker_api.storage

import com.learning.pet_tracker_api.model.Pet
import java.util.concurrent.atomic.AtomicInteger

// this is an in-memory cache setup for the pet api states


object PetStorage {

    private val pets = mutableListOf<Pet>()

    private val idCounter = AtomicInteger(1)

    fun getAll(): List<Pet> = pets

    fun getById(id: Int): Pet? {
        return pets.firstOrNull{ it.id == id }
    }

    fun add(pet: Pet): Pet {
        val newPet = pet.copy(id = idCounter.incrementAndGet())
        pets.add(newPet)
        return pet
    }


    fun update(id: Int, pet: Pet): Boolean {
        val oldPetIndex = pets.indexOfFirst { it.id == id }
        println("old pet index is $oldPetIndex")
        return if (oldPetIndex != -1) {
            pets[oldPetIndex] = pet.copy(id = pet.id)
            true
        } else {
            false
        }
    }

    fun delete(id: Int): Boolean {
        return pets.removeIf { it.id == id }
    }
}