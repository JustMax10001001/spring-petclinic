package com.justsoft.petclinic.models

import javax.persistence.Column

open class Person: BaseEntity() {

    @Column
    var firstName: String? = null

    @Column
    var lastName: String? = null
}