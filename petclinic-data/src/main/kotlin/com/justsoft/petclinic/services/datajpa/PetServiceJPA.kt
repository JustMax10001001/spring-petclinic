package com.justsoft.petclinic.services.datajpa

import com.justsoft.petclinic.models.pets.Pet
import com.justsoft.petclinic.repositories.PetRepository
import com.justsoft.petclinic.services.PetService
import org.springframework.context.annotation.Profile
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
@Profile("spring-data-jpa")
class PetServiceJPA(
        private val petRepository: PetRepository
): PetService {

    override fun findById(id: Long): Pet? = petRepository.findByIdOrNull(id)

    override fun save(anObject: Pet): Pet = petRepository.save(anObject)

    override fun findAll(): Set<Pet> =
            HashSet<Pet>().apply {
                petRepository.findAll().forEach { this.add(it) }
            }

    override fun delete(anObject: Pet) = petRepository.delete(anObject)

    override fun deleteById(id: Long) = petRepository.deleteById(id)
}