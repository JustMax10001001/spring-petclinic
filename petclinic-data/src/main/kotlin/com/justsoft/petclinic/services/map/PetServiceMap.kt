package com.justsoft.petclinic.services.map

import com.justsoft.petclinic.models.pets.Pet
import com.justsoft.petclinic.services.PetService
import com.justsoft.petclinic.services.PetTypeService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("dev")
class PetServiceMap(
        val petTypeService: PetTypeService,
) : AbstractMapService<Pet>(), PetService {

    override fun save(anObject: Pet): Pet {
        if (anObject.petType.id == null)
            petTypeService.save(anObject.petType)

        return super.save(anObject)
    }
}