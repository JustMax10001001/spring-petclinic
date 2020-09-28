package com.justsoft.petclinic.models.people

import com.justsoft.petclinic.models.pets.Pet
import com.justsoft.petclinic.models.pets.PetCreationContext
import com.justsoft.petclinic.models.pets.PetType
import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany

@DslMarker
annotation class OwnerDslMarker

@Entity
class Owner(
        firstName: String,
        lastName: String,
        @Column(nullable = false) var address: String,
        @Column(nullable = false) var city: String,
        @Column(nullable = false) var telephone: String,
        @OneToMany(cascade = [CascadeType.ALL])
        val pets: MutableSet<Pet> = HashSet()
) : Person(firstName, lastName) {
    override fun toString(): String {
        return "Owner(name='$firstName $lastName', id=$id, address='$address', city='$city', telephone='$telephone', pets=$pets)"
    }
}

@Suppress("MemberVisibilityCanBePrivate")
@OwnerDslMarker
class OwnerCreationContext {
    var firstName: String = "firstname"
    var lastName: String = "lastname"
    var address: String = "address"
    var city: String = "city"
    var telephone: String = "telephone"
    private val preOwner = Owner(firstName, lastName, address, city, telephone)

    fun pet(petType: PetType, initializer: PetCreationContext.() -> Unit) {
        preOwner.pets.add(PetCreationContext(petType).also(initializer).build(preOwner))
    }

    fun build(): Owner {
        preOwner.address = address
        preOwner.city = city
        preOwner.telephone = telephone
        preOwner.firstName = firstName
        preOwner.lastName = lastName
        return preOwner
    }
}

inline fun owner(initializer: OwnerCreationContext.() -> Unit): Owner =
        OwnerCreationContext().also(initializer).build()

