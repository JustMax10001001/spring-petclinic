package com.justsoft.petclinic.models.pets

import com.justsoft.petclinic.models.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class PetType(
        @Column(nullable = false)  var name: String,
) : BaseEntity() {
    override fun toString(): String {
        return "PetType(name='$name')"
    }
}
