package com.justsoft.petclinic.services

import com.justsoft.petclinic.models.pets.PetType
import org.springframework.stereotype.Service

@Service
interface PetTypeService: BaseEntityCrudService<PetType>