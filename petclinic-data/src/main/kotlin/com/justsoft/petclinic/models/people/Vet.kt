package com.justsoft.petclinic.models.people

import com.justsoft.petclinic.models.BaseEntity
import java.io.Serializable

class Vet(
        val specialties: MutableSet<VetSpecialty> = HashSet(),
        firstName: String,
        lastName: String,
) : Person(firstName, lastName)

class VetSpecialty(
        var specialtyName: String
) : BaseEntity(), Serializable