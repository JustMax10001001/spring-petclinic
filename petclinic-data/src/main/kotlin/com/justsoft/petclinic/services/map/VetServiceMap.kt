package com.justsoft.petclinic.services.map

import com.justsoft.petclinic.models.Vet
import com.justsoft.petclinic.services.VetService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("dev")
class VetServiceMap: AbstractMapService<Vet>(), VetService