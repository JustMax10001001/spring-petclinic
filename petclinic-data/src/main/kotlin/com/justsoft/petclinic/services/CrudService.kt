package com.justsoft.petclinic.services

import com.justsoft.petclinic.models.Owner

interface CrudService<T, ID> {

    fun findById(id: ID): T?

    fun save(anObject: T): T

    fun findAll(): Set<T>

    fun delete(anObject: T)

    fun deleteById(id: ID)
}