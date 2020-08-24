package com.justsoft.petclinic.models

import com.justsoft.petclinic.models.pets.Pet
import java.time.LocalDate

class Visit: BaseEntity() {

    var date: LocalDate? = null

    var description: String? = null

    var pet: Pet? = null
}