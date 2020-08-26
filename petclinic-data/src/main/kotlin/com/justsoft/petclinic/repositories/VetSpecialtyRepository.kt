package com.justsoft.petclinic.repositories

import com.justsoft.petclinic.models.people.VetSpecialty
import org.springframework.data.repository.CrudRepository

interface VetSpecialtyRepository: CrudRepository<VetSpecialty, Long>