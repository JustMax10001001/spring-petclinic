package com.justsoft.petclinic.services.map

import com.justsoft.petclinic.models.pets.Pet
import com.justsoft.petclinic.services.PetService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("dev")
class PetServiceMap : AbstractMapService<Pet>(), PetService