package com.justsoft.petclinic.controllers

import org.springframework.stereotype.Controller

@Controller
class IndexController {

    //@RequestMapping("", "/", "index", "index.html")
    fun index(): String{
        return "index"
    }
}