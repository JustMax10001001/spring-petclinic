package com.justsoft.petclinic.services

import com.justsoft.petclinic.models.Owner

interface OwnerService: BaseEntityCrudService<Owner> {

    fun findByLastName(lastName: String): Owner?
}