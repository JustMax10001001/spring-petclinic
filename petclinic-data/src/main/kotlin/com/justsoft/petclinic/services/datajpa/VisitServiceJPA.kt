package com.justsoft.petclinic.services.datajpa

import com.justsoft.petclinic.models.Visit
import com.justsoft.petclinic.repositories.VisitRepository
import com.justsoft.petclinic.services.VisitService
import org.springframework.context.annotation.Profile
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
@Profile("spring-data-jpa")
class VisitServiceJPA(
        private val visitRepository: VisitRepository
): VisitService{

    override fun findById(id: Long): Visit? = visitRepository.findByIdOrNull(id)

    override fun save(anObject: Visit): Visit = visitRepository.save(anObject)

    override fun findAll(): Set<Visit> =
            HashSet<Visit>().apply {
                visitRepository.findAll().forEach { this.add(it) }
            }

    override fun delete(anObject: Visit) = visitRepository.delete(anObject)

    override fun deleteById(id: Long) = visitRepository.deleteById(id)
}