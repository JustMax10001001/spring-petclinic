package com.justsoft.petclinic.models.people

import com.justsoft.petclinic.models.pets.Pet

class Owner(
        firstName: String,
        lastName: String,
        val pets: Set<Pet> = HashSet(),
        var address: String,
        var city: String,
        var telephone: String
): Person(firstName, lastName)