package com.justsoft.petclinic.models.pets

import com.justsoft.petclinic.models.BaseEntity
import com.justsoft.petclinic.models.Visit
import com.justsoft.petclinic.models.people.Owner
import java.time.LocalDate
import javax.persistence.*

@Entity
open class Pet(
        @Column(nullable = false) var name: String,
        @OneToOne
        var petType: PetType,
        @Column(nullable = false) var birthDate: LocalDate,
        @ManyToOne var owner: Owner,
        @OneToMany(mappedBy = "pet", cascade = [CascadeType.ALL]) val visits: MutableSet<Visit> = HashSet()
) : BaseEntity()