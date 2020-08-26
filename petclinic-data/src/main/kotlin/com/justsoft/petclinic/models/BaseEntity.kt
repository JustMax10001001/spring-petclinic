package com.justsoft.petclinic.models

import java.io.Serializable
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
class BaseEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
): Serializable