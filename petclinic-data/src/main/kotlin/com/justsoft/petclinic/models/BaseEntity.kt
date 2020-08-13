package com.justsoft.petclinic.models

import java.io.Serializable
import javax.persistence.GeneratedValue
import javax.persistence.Id

open class BaseEntity(
        @Id
        @GeneratedValue
        val id: Long? = null
): Serializable