package com.justsoft.petclinic.repositories

import com.justsoft.petclinic.models.people.Vet
import org.springframework.data.repository.CrudRepository

interface VetRepository: CrudRepository<Vet, Long>