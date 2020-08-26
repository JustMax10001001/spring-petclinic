package com.justsoft.petclinic.repositories

import com.justsoft.petclinic.models.pets.Pet
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PetRepository: CrudRepository<Pet, Long>