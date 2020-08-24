package com.justsoft.petclinic.controllers

import com.justsoft.petclinic.services.VetService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/vets")
class VetController(
        private val vetService: VetService
) {

    @RequestMapping("", "/", "/index", "/index.html")
    fun listVets(model: Model): String {

        model["vets"] = vetService.findAll()

        return "vets/index"
    }
}