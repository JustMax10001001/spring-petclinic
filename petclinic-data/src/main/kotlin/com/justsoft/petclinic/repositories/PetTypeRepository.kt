package com.justsoft.petclinic.repositories

import com.justsoft.petclinic.models.pets.PetType
import org.springframework.data.repository.CrudRepository

interface PetTypeRepository: CrudRepository<PetType, Long>