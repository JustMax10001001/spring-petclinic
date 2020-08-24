package com.justsoft.petclinic.models

import com.justsoft.petclinic.models.pets.Pet
import java.time.LocalDate

class Visit(
        var date: LocalDate,
        var pet: Pet,
        var description: String = "",
) : BaseEntity()