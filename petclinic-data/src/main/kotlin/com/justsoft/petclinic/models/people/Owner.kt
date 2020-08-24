package com.justsoft.petclinic.models.people

import com.justsoft.petclinic.models.pets.Pet

class Owner(
        val pets: Set<Pet> = HashSet(),
        firstName: String,
        lastName: String,
): Person(firstName, lastName)