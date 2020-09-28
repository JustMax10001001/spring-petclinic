package com.justsoft.petclinic.models.pets

import com.justsoft.petclinic.models.BaseEntity
import com.justsoft.petclinic.models.Visit
import com.justsoft.petclinic.models.people.Owner
import java.time.LocalDate
import javax.persistence.*

@DslMarker
private annotation class PetDslMarker

@Entity
@PetDslMarker
class Pet(
        @Column(nullable = false) var name: String,
        @OneToOne
        var petType: PetType,
        @Column(nullable = false) var birthDate: LocalDate,
        @ManyToOne var owner: Owner,
        @OneToMany(mappedBy = "pet", cascade = [CascadeType.ALL]) val visits: MutableSet<Visit> = HashSet()
) : BaseEntity() {
    override fun toString(): String {
        return "Pet(name='$name', petType=$petType, birthDate=$birthDate, owner=${owner.firstName} ${owner.lastName}, visits=$visits)"
    }
}

class PetCreationContext(
        var petType: PetType
) {
    var name: String = "name"
    var birthDate: LocalDate = LocalDate.MIN

    fun build(owner: Owner): Pet = Pet(name, petType, birthDate, owner)
}

@DslMarker
private annotation class PetListDslMarker

@PetListDslMarker
private class PetList: ArrayList<Pet>()

class PetListInitializationContext(val owner: Owner) {
    val petList: ArrayList<Pet> = PetList()

    inline fun pet(petType: PetType, initializer: PetCreationContext.() -> Unit) {
        petList.add(PetCreationContext(petType).also(initializer).build(owner))
    }

    fun build(): ArrayList<Pet> = petList
}