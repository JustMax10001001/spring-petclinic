package com.justsoft.petclinic.repositories

import com.justsoft.petclinic.models.people.Owner
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OwnerRepository: CrudRepository<Owner, Long>