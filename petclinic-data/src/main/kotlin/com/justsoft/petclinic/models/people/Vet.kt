package com.justsoft.petclinic.models.people

import com.justsoft.petclinic.models.BaseEntity
import java.io.Serializable
import javax.persistence.*

@Entity
class Vet(
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "VET_TO_SPECIALTY", joinColumns = [JoinColumn(name = "vet_id")],
                inverseJoinColumns = [JoinColumn(name = "specialty_id")])
        val specialties: MutableSet<VetSpecialty> = HashSet(),
        firstName: String,
        lastName: String,
) : Person(firstName, lastName)

@Entity
@Table(name = "SPECIALTY")
class VetSpecialty(
        @Column(nullable = false) var specialtyName: String,
        //@ManyToMany(mappedBy = "specialties") val vets: MutableSet<Vet> = HashSet()
) : BaseEntity(), Serializable