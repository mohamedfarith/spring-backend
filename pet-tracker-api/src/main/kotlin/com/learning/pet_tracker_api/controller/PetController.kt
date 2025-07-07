package com.learning.pet_tracker_api.controller

import com.learning.pet_tracker_api.model.Pet
import com.learning.pet_tracker_api.service.PetService
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/pets")
class PetController(private val service: PetService) {

    @GetMapping
    fun getAllPets(): ResponseEntity<List<Pet>> = ResponseEntity.ok(service.getAllPets())

    @GetMapping("{id}")
    fun getPetById(@PathVariable id: Int): ResponseEntity<Pet> {
        val pet = service.getPetById(id)
        return pet?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun addPet(@RequestBody pet: Pet): ResponseEntity<Pet?> {
        val saved = service.addPet(pet)
        return ResponseEntity.status(HttpStatus.CREATED).body(saved)
    }

    @PutMapping("/{id}")
    fun updatePet(@PathVariable id: Int, @RequestBody pet: Pet): ResponseEntity<Void> {
        return if (service.updatePet(id, pet)) ResponseEntity.ok().build()
        else ResponseEntity.notFound().build()
    }
    @DeleteMapping("/{id}")
    fun deletePet(@PathVariable id: Int): ResponseEntity<Void> {
        return if (service.deletePet(id)) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }


}