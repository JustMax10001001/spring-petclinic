package com.justsoft.petclinic

import com.justsoft.petclinic.models.Owner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class PetClinicApplication

fun main(args: Array<String>) {
    runApplication<PetClinicApplication>(*args)

    //val owner = Owner()
}
