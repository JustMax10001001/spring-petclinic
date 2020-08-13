package com.justsoft.petclinic.services.map

import com.justsoft.petclinic.models.Vet
import com.justsoft.petclinic.services.CrudService

class VetServiceMap: AbstractMapService<Vet>(), CrudService<Vet, Long>