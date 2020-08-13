package com.justsoft.petclinic.services.map

import com.justsoft.petclinic.models.Owner
import com.justsoft.petclinic.services.OwnerService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("dev")
class OwnerServiceMap : AbstractMapService<Owner>(), OwnerService {
    override fun findByLastName(lastName: String): Owner? {
        TODO("Not yet implemented")
    }
}