package com.learning.pet_tracker_api.service

import com.learning.pet_tracker_api.model.Pet
import com.learning.pet_tracker_api.storage.PetStorage
import org.springframework.stereotype.Service

@Service
class PetService {
    fun getAllPets() = PetStorage.getAll()
    fun getPetById(id: Int) = PetStorage.getById(id)
    fun addPet(pet: Pet) = PetStorage.add(pet)
    fun updatePet(id: Int, pet: Pet) = PetStorage.update(id, pet)
    fun deletePet(id: Int) = PetStorage.delete(id)

}