package com.justsoft.petclinic.models.people

import com.justsoft.petclinic.models.BaseEntity
import javax.persistence.Column

open class Person(
        @Column var firstName: String,
        @Column var lastName: String
) : BaseEntity()