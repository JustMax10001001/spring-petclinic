package com.justsoft.petclinic.services.map

import com.justsoft.petclinic.models.people.owner
import com.justsoft.petclinic.models.pets.PetType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class OwnerServiceMapTest {

    private val ownerServiceMap: OwnerServiceMap = OwnerServiceMap(PetServiceMap(PetTypeServiceMap()))

    private val testOwnerId: Long = 555
    private val testOwnerLastName = "owner"

    @BeforeEach
    fun setUp() {
        ownerServiceMap.save(owner {
            firstName = "test"
            lastName = testOwnerLastName
            id = testOwnerId
        })
    }

    @Test
    fun findAll() {
        assertEquals(1, ownerServiceMap.findAll().count())
    }

    @Test
    fun findById() {
        val owner = ownerServiceMap.findById(testOwnerId)
        assertNotNull(owner)
        assertEquals(testOwnerId, owner?.id)
    }

    @Test
    fun saveWithSetId() {
        val owner = owner {
            firstName = "Test"
            lastName = "Subject"
        }

        ownerServiceMap.save(owner)
        assertEquals(2, ownerServiceMap.findAll().count())
    }

    @Test
    fun saveWithUnsetId() {
        val owner = owner {
            firstName = "Test"
            lastName = "Subject"
        }

        ownerServiceMap.save(owner)
        assertNotNull(owner.id)
        assertEquals(2, ownerServiceMap.findAll().count())
    }

    @Test
    fun saveWithPetsWithoutId() {
        val cat = PetType("cat")
        val owner = owner {
            firstName = "Test"
            lastName = "Subject"

            pet(cat) { name = "grumper" }
            pet(cat) { name = "smiler" }
        }
        ownerServiceMap.save(owner)
        assertEquals(2, ownerServiceMap.findAll().count())
        assertNotNull(owner.id)         // check if owner had id assigned
        owner.pets.forEach {
            assertNotNull(it.id)        // check if pet had its id assigned
            assertNotNull(it.petType.id)// check if pet type had its id assigned
        }
    }

    @Test
    fun delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(testOwnerId)!!)

        assertEquals(0, ownerServiceMap.findAll().size)
    }

    @Test
    fun deleteById() {
        ownerServiceMap.deleteById(testOwnerId)

        assertEquals(0, ownerServiceMap.findAll().size)
    }

    @Test
    fun findByLastName() {
        assertNotNull(ownerServiceMap.findByLastName(testOwnerLastName))
        assertEquals(testOwnerId, ownerServiceMap.findByLastName(testOwnerLastName)!!.id)
    }
}