package com.justsoft.petclinic.services.map

import com.justsoft.petclinic.models.Owner
import com.justsoft.petclinic.services.CrudService
import com.justsoft.petclinic.services.OwnerService

class OwnerServiceMap : AbstractMapService<Owner>(), OwnerService {
    override fun findByLastName(lastName: String): Owner? {
        TODO("Not yet implemented")
    }
}