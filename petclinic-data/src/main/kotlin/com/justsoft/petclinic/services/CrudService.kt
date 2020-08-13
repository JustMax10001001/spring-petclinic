package com.justsoft.petclinic.services

import com.justsoft.petclinic.models.Owner

interface CrudService<T, ID> {

    fun findById(id: ID): T?

    fun save(t: T)

    fun findAll(): Set<T>
}