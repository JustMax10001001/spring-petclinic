package com.justsoft.petclinic.services.map

import com.justsoft.petclinic.models.people.Vet
import com.justsoft.petclinic.services.VetService
import com.justsoft.petclinic.services.VetSpecialtyService
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service
@Profile("dev")
class VetServiceMap(
        val vetSpecialtyService: VetSpecialtyService
) : AbstractMapService<Vet>(), VetService {

    override fun save(anObject: Vet): Vet {
        anObject.specialties.forEach { vetSpecialty ->
            if (vetSpecialty.id == null)
                vetSpecialtyService.save(vetSpecialty)
        }
        return super.save(anObject)
    }
}