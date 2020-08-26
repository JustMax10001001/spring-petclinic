package com.justsoft.petclinic.repositories

import com.justsoft.petclinic.models.Visit
import org.springframework.data.repository.CrudRepository

interface VisitRepository: CrudRepository<Visit, Long>