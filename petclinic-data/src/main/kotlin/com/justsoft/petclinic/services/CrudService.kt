package com.justsoft.petclinic.services

interface CrudService<T, ID> {

    fun findById(id: ID): T?

    fun save(anObject: T): T

    fun findAll(): Set<T>

    fun delete(anObject: T)

    fun deleteById(id: ID)
}