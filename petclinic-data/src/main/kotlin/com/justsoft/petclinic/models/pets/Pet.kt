package com.justsoft.petclinic.models.pets

import com.justsoft.petclinic.models.BaseEntity
import com.justsoft.petclinic.models.Visit
import com.justsoft.petclinic.models.people.Owner
import java.time.LocalDate
import javax.persistence.*

@Entity
open class Pet(
        @Column(nullable = false) open var name: String,
        @OneToOne
        open var petType: PetType,
        @Column(nullable = false) open var birthDate: LocalDate,
        @ManyToOne open var owner: Owner,
        @OneToMany(mappedBy = "pet", cascade = [CascadeType.ALL]) open val visits: MutableSet<Visit> = HashSet()
) : BaseEntity()