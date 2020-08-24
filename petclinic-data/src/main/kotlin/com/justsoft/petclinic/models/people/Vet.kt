package com.justsoft.petclinic.models.people

import com.justsoft.petclinic.models.BaseEntity
import java.io.Serializable

class Vet(
        var specialty: VetSpecialty
) : Person()

class VetSpecialty(
        var specialtyName: String
) : BaseEntity(), Serializable