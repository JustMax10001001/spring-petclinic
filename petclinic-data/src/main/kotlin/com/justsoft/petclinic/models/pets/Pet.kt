package com.justsoft.petclinic.models.pets

import com.justsoft.petclinic.models.BaseEntity
import com.justsoft.petclinic.models.people.Owner
import java.time.LocalDate

class Pet: BaseEntity() {

    var petType: PetType? = null

    var birthDate: LocalDate? = null

    var owner: Owner? = null
}