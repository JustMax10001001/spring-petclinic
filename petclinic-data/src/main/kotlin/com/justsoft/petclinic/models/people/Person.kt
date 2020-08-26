package com.justsoft.petclinic.models.people

import com.justsoft.petclinic.models.BaseEntity
import javax.persistence.Column
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class Person(
        @Column(nullable = false) var firstName: String,
        @Column(nullable = false) var lastName: String
) : BaseEntity()