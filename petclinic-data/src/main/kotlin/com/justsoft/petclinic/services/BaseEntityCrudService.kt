package com.justsoft.petclinic.services

import com.justsoft.petclinic.models.BaseEntity

interface BaseEntityCrudService<T: BaseEntity> : CrudService<T, Long>