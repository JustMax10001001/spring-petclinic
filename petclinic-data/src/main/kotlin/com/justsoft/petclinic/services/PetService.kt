package com.justsoft.petclinic.services

import com.justsoft.petclinic.models.Owner
import com.justsoft.petclinic.models.Pet

interface PetService {

    fun findById(id: Long): Pet?

    fun save(pet: Pet)

    fun findAll(): Set<Pet>
}