package com.justsoft.petclinic.services

import com.justsoft.petclinic.models.people.Vet
import org.springframework.stereotype.Service

@Service
interface VetService: BaseEntityCrudService<Vet>