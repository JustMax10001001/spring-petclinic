package com.justsoft.petclinic.services.datajpa

import com.justsoft.petclinic.models.people.Vet
import com.justsoft.petclinic.repositories.VetRepository
import com.justsoft.petclinic.services.VetService
import org.springframework.context.annotation.Profile
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
@Profile("spring-data-jpa")
class VetServiceJPA(
        private val vetRepository: VetRepository
): VetService {

    override fun findById(id: Long): Vet? = vetRepository.findByIdOrNull(id)

    override fun save(anObject: Vet): Vet = vetRepository.save(anObject)

    override fun findAll(): Set<Vet> =
            HashSet<Vet>().apply {
                vetRepository.findAll().forEach { this.add(it) }
            }

    override fun delete(anObject: Vet) = vetRepository.delete(anObject)

    override fun deleteById(id: Long) = vetRepository.deleteById(id)
}