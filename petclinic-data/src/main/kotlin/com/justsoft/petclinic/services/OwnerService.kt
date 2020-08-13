package com.justsoft.petclinic.services

import com.justsoft.petclinic.models.Owner
import org.springframework.stereotype.Service

@Service
interface OwnerService: BaseEntityCrudService<Owner> {

    fun findByLastName(lastName: String): Owner?
}