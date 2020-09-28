package com.justsoft.petclinic.repositories

import com.justsoft.petclinic.PetClinicApplication
import com.justsoft.petclinic.models.people.Owner
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@SpringBootTest(classes = [PetClinicApplication::class])
@ExtendWith(SpringExtension::class)
class OwnerRepositoryIT {

    @Autowired
    lateinit var ownerRepository: OwnerRepository

    @Test
    fun testRepositoryAdd() {
        val owner = Owner("first", "last", "address", "city", "555-555")
        ownerRepository.save(owner)
        assertNotNull(owner.id)
        assert(ownerRepository.count() > 0)
    }
}