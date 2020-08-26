package com.justsoft.petclinic.models

import com.justsoft.petclinic.models.pets.Pet
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Visit(
        @Column(nullable = false) var date: LocalDate,
        @ManyToOne
        @JoinColumn(name = "pet_id")
        var pet: Pet,
        @Column(nullable = false) var description: String = "",
) : BaseEntity()