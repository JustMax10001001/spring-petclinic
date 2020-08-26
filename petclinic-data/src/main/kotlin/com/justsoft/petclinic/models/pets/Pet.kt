package com.justsoft.petclinic.models.pets

import com.justsoft.petclinic.models.BaseEntity
import com.justsoft.petclinic.models.people.Owner
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.OneToOne

@Entity
open class Pet(
        @Column(nullable = false) var name: String,
        @OneToOne
        var petType: PetType,
        @Column(nullable = false) var birthDate: LocalDate,
        @ManyToOne var owner: Owner,
) : BaseEntity()