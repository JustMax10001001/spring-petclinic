package com.justsoft.petclinic.services

import com.justsoft.petclinic.models.Owner

interface OwnerService {

    fun findByLastName(lastName: String): Owner?

    fun findById(id: Long): Owner?

    fun save(owner: Owner)

    fun findAll(): Set<Owner>
}