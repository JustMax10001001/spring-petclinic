package com.justsoft.petclinic.models.people

import com.justsoft.petclinic.models.pets.Pet

class Owner: Person() {

    val pets: Set<Pet> = HashSet()
}