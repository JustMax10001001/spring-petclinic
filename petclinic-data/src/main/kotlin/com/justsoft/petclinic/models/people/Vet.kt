package com.justsoft.petclinic.models.people

import com.justsoft.petclinic.models.BaseEntity
import java.io.Serializable
import javax.persistence.*

@Entity
class Vet(
        firstName: String,
        lastName: String,
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "VET_TO_SPECIALTY", joinColumns = [JoinColumn(name = "vet_id")],
                inverseJoinColumns = [JoinColumn(name = "specialty_id")])
        val specialties: MutableSet<VetSpecialty> = HashSet(),
) : Person(firstName, lastName)

@Entity
@Table(name = "SPECIALTY")
class VetSpecialty(
        @Column(nullable = false) var specialtyName: String,
) : BaseEntity(), Serializable

@DslMarker
private annotation class VetDslMarker

@VetDslMarker
class VetCreationContext {
    var firstName: String = "firstname"
    var lastName: String = "lastname"
    val specialties = mutableSetOf<VetSpecialty>()

    fun specialty(specialty: VetSpecialty) {
        specialties.add(specialty)
    }

    fun build(): Vet {
        return Vet(firstName, lastName, specialties)
    }
}

fun vet(initializer: VetCreationContext.() -> Unit): Vet {
    return VetCreationContext().apply(initializer).build()
}