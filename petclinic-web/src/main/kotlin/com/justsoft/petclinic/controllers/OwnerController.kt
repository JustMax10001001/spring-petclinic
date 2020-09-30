package com.justsoft.petclinic.controllers

import com.justsoft.petclinic.services.OwnerService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/owners")
class OwnerController(
        private val ownerService: OwnerService
) {

    @RequestMapping("", "/", "/index", "/index.html")
    fun listOwners(model: Model): String {
        model["owners"] = ownerService.findAll()

        return "owners/index"
    }

    @RequestMapping("/find")
    fun findOwners(): String {
        return "not_implemented"
    }
}