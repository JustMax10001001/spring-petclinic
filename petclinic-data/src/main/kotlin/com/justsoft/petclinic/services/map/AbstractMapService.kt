package com.justsoft.petclinic.services.map

import com.justsoft.petclinic.models.BaseEntity

abstract class AbstractMapService<T : BaseEntity> {

    private val map: MutableMap<Long, T> = HashMap()

    fun findAll(): Set<T> = HashSet(map.values)

    fun findById(id: Long) = map[id]

    open fun save(anObject: T): T {
        if (anObject.id == null){
            anObject.id = getNextId()
        }

        map[anObject.id!!] = anObject

        return anObject
    }

    private fun getNextId(): Long = map.size.toLong() + 1

    fun delete(anObject: T) {
        map.entries.removeIf { it.value == anObject }
    }

    fun deleteById(id: Long) {
        map.remove(id)
    }
}