package com.justsoft.petclinic.services.map

import com.justsoft.petclinic.models.Pet
import com.justsoft.petclinic.services.CrudService

class PetServiceMap : AbstractMapService<Pet>(), CrudService<Pet, Long>