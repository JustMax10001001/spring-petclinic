package com.justsoft.petclinic.services

import com.justsoft.petclinic.models.Owner
import com.justsoft.petclinic.models.Pet
import org.springframework.stereotype.Service

@Service
interface PetService: BaseEntityCrudService<Pet>