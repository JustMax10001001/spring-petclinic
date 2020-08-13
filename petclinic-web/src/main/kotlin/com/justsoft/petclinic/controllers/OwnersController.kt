package com.justsoft.petclinic.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/owners")
class OwnersController {

    @RequestMapping("", "/", "/index", "/index.html")
    fun listOwners(): String {
        return "owners/index"
    }
}