package com.justsoft.petclinic.models.pets

import com.justsoft.petclinic.models.BaseEntity
import com.justsoft.petclinic.models.Visit
import com.justsoft.petclinic.models.people.Owner
import com.justsoft.petclinic.models.people.OwnerDslMarker
import java.time.LocalDate
import javax.persistence.*

@Entity
class Pet(
        @Column(nullable = false) var name: String,
        @OneToOne
        var petType: PetType,
        @Column(nullable = false) var birthDate: LocalDate,
        @ManyToOne var owner: Owner,
        @OneToMany(mappedBy = "pet", cascade = [CascadeType.ALL]) val visits: MutableSet<Visit> = HashSet()
) : BaseEntity() {
    override fun toString(): String {
        return "Pet(name='$name', id=$id, petType=$petType, birthDate=$birthDate, owner=${owner.firstName} ${owner.lastName}, visits=$visits)"
    }
}

@OwnerDslMarker
class PetCreationContext(
        var petType: PetType
) {
    var name: String = "name"
    var birthDate: LocalDate = LocalDate.MIN

    fun build(owner: Owner): Pet = Pet(name, petType, birthDate, owner)
}