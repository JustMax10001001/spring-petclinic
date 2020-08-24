package com.justsoft.petclinic.services.map

import com.justsoft.petclinic.models.pets.PetType
import com.justsoft.petclinic.services.PetTypeService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("dev")
class PetTypeServiceMap: AbstractMapService<PetType>(), PetTypeService