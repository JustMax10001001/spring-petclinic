package com.justsoft.petclinic.services.map

import com.justsoft.petclinic.models.Visit
import com.justsoft.petclinic.services.VisitService
import org.springframework.stereotype.Service

@Service
class VisitServiceMap: AbstractMapService<Visit>(), VisitService