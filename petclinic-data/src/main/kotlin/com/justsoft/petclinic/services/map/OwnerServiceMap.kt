package com.justsoft.petclinic.services.map

import com.justsoft.petclinic.models.Owner
import com.justsoft.petclinic.services.CrudService

class OwnerServiceMap : AbstractMapService<Owner>(), CrudService<Owner, Long>