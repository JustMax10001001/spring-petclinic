package com.justsoft.petclinic.models

import java.io.Serializable
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
open class BaseEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) open var id: Long? = null
): Serializable