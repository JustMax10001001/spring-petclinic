package com.justsoft.petclinic.services

import com.justsoft.petclinic.models.pets.Pet
import org.springframework.stereotype.Service

@Service
interface PetService: BaseEntityCrudService<Pet>