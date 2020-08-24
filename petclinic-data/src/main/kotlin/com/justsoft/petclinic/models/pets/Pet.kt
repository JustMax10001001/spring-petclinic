package com.justsoft.petclinic.models.pets

import com.justsoft.petclinic.models.BaseEntity
import com.justsoft.petclinic.models.people.Owner
import java.time.LocalDate

open class Pet(
        var petType: PetType,
        var birthDate: LocalDate,
        var owner: Owner,
) : BaseEntity()