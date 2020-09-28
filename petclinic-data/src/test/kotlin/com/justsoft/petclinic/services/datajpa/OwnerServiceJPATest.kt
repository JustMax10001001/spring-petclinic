package com.justsoft.petclinic.services.datajpa

import com.justsoft.petclinic.models.people.Owner
import com.justsoft.petclinic.models.people.owner
import com.justsoft.petclinic.repositories.OwnerRepository
import com.justsoft.petclinic.repositories.PetRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class OwnerServiceJPATest {

    @Mock private lateinit var ownerRepository: OwnerRepository
    @Mock private lateinit var petRepository: PetRepository

    @InjectMocks
    private lateinit var ownerServiceJPA: OwnerServiceJPA

    private val testOwnerLastName = "Smtih"
    private val testOwnerId: Long = 34
    private val testOwner = owner {
        lastName = testOwnerLastName
        id = testOwnerId
    }

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun findByLastName() {
        val lastNameSmith = "Smith"
        val returnOwner = owner {
            id = 1
            lastName = lastNameSmith
            firstName = "Stan"
        }

        `when`(ownerRepository.findOwnerByLastNameIgnoreCase(anyString())).thenReturn(returnOwner)

        val smith = ownerServiceJPA.findByLastName(lastNameSmith)

        assertNotNull(smith)
        assertEquals(lastNameSmith, smith?.lastName)
        verify(ownerRepository).findOwnerByLastNameIgnoreCase(anyString())
    }

    @Test
    fun findById() {
        `when`(ownerRepository.findById(testOwnerId)).thenReturn(Optional.of(testOwner))

        val owner = ownerServiceJPA.findById(testOwnerId)

        assertNotNull(owner)
        assertEquals(testOwnerId, owner?.id)
    }

    @Test
    fun save() {
        val ownerToSave = owner {  }
        val ownerCaptor = ArgumentCaptor.forClass(Owner::class.java)
        `when`(ownerRepository.save(ownerCaptor.capture())).thenReturn(ownerCaptor.value.apply { id = 5 })

        val saved = ownerServiceJPA.save(ownerToSave)

        assertNotNull(saved.id)
        assertEquals(5, saved.id)
    }

    @Test
    fun findNull() {
        assertNull(ownerServiceJPA.findById(-23))
    }

    @Test
    fun findAll() {
        val testOwner2 = owner { id = 35 }
        val ownerSet = setOf(testOwner, testOwner2)

        `when`(ownerRepository.findAll()).thenReturn(ownerSet)

        val foundOwners = ownerServiceJPA.findAll()
        assertEquals(2, foundOwners.size)
    }

    @Test
    fun delete() {
        ownerServiceJPA.delete(testOwner)
        verify(ownerRepository).delete(testOwner)
    }

    @Test
    fun deleteById() {
        ownerServiceJPA.deleteById(testOwnerId)
        verify(ownerRepository).deleteById(testOwnerId)
    }
}