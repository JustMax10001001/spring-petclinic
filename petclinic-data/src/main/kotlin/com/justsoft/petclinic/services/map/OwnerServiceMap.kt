package com.justsoft.petclinic.services.map

import com.justsoft.petclinic.models.people.Owner
import com.justsoft.petclinic.services.OwnerService
import com.justsoft.petclinic.services.PetService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("dev")
class OwnerServiceMap(
        val petService: PetService,
) : AbstractMapService<Owner>(), OwnerService {
    override fun findByLastName(lastName: String): Owner? {
        return findAll().find { owner -> owner.lastName.equals(lastName, true) }
    }

    override fun save(anObject: Owner): Owner {
        anObject.pets.forEach { pet -> if (pet.id == null) petService.save(pet) }
        return super.save(anObject)
    }
}