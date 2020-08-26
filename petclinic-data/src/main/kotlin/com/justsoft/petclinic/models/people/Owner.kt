package com.justsoft.petclinic.models.people

import com.justsoft.petclinic.models.pets.Pet
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class Owner(
        firstName: String,
        lastName: String,
        @Column(nullable = false) var address: String,
        @Column(nullable = false) var city: String,
        @Column(nullable = false) var telephone: String,
        @OneToMany
        val pets: MutableSet<Pet> = HashSet()
): Person(firstName, lastName)