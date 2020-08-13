package com.justsoft.petclinic.services

import com.justsoft.petclinic.models.Vet

interface VetService {

    fun findById(id: Long): Vet?

    fun save(vet: Vet)

    fun findAll(): Set<Vet>
}