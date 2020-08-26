package com.justsoft.petclinic.services.datajpa


import com.justsoft.petclinic.models.pets.PetType
import com.justsoft.petclinic.repositories.PetTypeRepository
import com.justsoft.petclinic.services.PetTypeService
import org.springframework.context.annotation.Profile
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
@Profile("spring-data-jpa")
class PetTypeServiceJPA(
        private val petTypeRepository: PetTypeRepository
): PetTypeService {

    override fun findById(id: Long): PetType? = petTypeRepository.findByIdOrNull(id)

    override fun save(anObject: PetType): PetType = petTypeRepository.save(anObject)

    override fun findAll(): Set<PetType> =
            HashSet<PetType>().apply {
                petTypeRepository.findAll().forEach { this.add(it) }
            }

    override fun delete(anObject: PetType) = petTypeRepository.delete(anObject)

    override fun deleteById(id: Long) = petTypeRepository.deleteById(id)
}