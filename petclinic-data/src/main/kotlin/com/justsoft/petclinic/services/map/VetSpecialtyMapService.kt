package com.justsoft.petclinic.services.map

import com.justsoft.petclinic.models.people.VetSpecialty
import com.justsoft.petclinic.services.VetSpecialtyService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("dev")
class VetSpecialtyMapService: AbstractMapService<VetSpecialty>(), VetSpecialtyService