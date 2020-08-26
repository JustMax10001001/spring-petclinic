package com.justsoft.petclinic.services.datajpa

import com.justsoft.petclinic.models.people.VetSpecialty
import com.justsoft.petclinic.repositories.VetSpecialtyRepository
import com.justsoft.petclinic.services.VetSpecialtyService
import org.springframework.context.annotation.Profile
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
@Profile("spring-data-jpa")
class VetSpecialtyServiceJPA(
        private val vetSpecialtyRepository: VetSpecialtyRepository
): VetSpecialtyService {

    override fun findById(id: Long): VetSpecialty? = vetSpecialtyRepository.findByIdOrNull(id)

    override fun save(anObject: VetSpecialty): VetSpecialty = vetSpecialtyRepository.save(anObject)

    override fun findAll(): Set<VetSpecialty> =
            HashSet<VetSpecialty>().apply {
                vetSpecialtyRepository.findAll().forEach { this.add(it) }
            }

    override fun delete(anObject: VetSpecialty) = vetSpecialtyRepository.delete(anObject)

    override fun deleteById(id: Long) = vetSpecialtyRepository.deleteById(id)
}