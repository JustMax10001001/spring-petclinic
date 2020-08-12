package com.justsoft.petclinic.models

import java.time.LocalDate

class Pet: BaseEntity() {

    var petType: PetType? = null

    var birthDate: LocalDate? = null

    var owner: Owner? = null
}