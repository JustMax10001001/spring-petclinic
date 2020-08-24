package com.justsoft.petclinic.models.people

import com.justsoft.petclinic.models.BaseEntity
import javax.persistence.Column

open class Person: BaseEntity() {

    @Column
    var firstName: String? = null

    @Column
    var lastName: String? = null
}