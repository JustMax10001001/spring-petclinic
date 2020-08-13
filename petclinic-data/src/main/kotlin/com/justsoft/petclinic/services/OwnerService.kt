package com.justsoft.petclinic.services

import com.justsoft.petclinic.models.Owner

interface OwnerService: CrudService<Owner, Long> {

    fun findByLastName(lastName: String): Owner?
}