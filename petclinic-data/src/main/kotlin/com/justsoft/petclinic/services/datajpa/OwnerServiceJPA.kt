package com.justsoft.petclinic.services.datajpa

import com.justsoft.petclinic.models.people.Owner
import com.justsoft.petclinic.repositories.OwnerRepository
import com.justsoft.petclinic.services.OwnerService
import org.springframework.context.annotation.Profile
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
@Profile("spring-data-jpa")
class OwnerServiceJPA(
        private val ownerRepository: OwnerRepository
): OwnerService {

    override fun findByLastName(lastName: String): Owner? = ownerRepository.findOwnerByLastNameIgnoreCase(lastName)

    override fun findById(id: Long): Owner? = ownerRepository.findByIdOrNull(id)

    override fun save(anObject: Owner): Owner = ownerRepository.save(anObject)

    override fun findAll(): Set<Owner> =
            HashSet<Owner>().apply {
                ownerRepository.findAll().forEach { this.add(it) }
            }

    override fun delete(anObject: Owner) = ownerRepository.delete(anObject)

    override fun deleteById(id: Long) = ownerRepository.deleteById(id)
}