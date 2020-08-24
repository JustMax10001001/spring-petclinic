package com.justsoft.petclinic.bootstrap

import com.justsoft.petclinic.models.people.Owner
import com.justsoft.petclinic.models.people.Vet
import com.justsoft.petclinic.services.OwnerService
import com.justsoft.petclinic.services.PetService
import com.justsoft.petclinic.services.VetService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataLoader(
        private val ownerService: OwnerService,
        private val petService: PetService,
        private val vetService: VetService
) : CommandLineRunner {


    override fun run(vararg args: String?) {
        ownerService.save(
                Owner(
                        firstName = "Michael",
                        lastName = "Weston",
                        address = "Kulparkivska",
                        city = "Lviv",
                        telephone = "0223352"
                )
        )
        ownerService.save(
                Owner(
                        firstName = "Fiona",
                        lastName = "Shrek",
                        address = "Uzhgorodska",
                        city = "Lviv",
                        telephone = "0223351"
                )
        )

        println("Loaded owners.")

        vetService.save(
                Vet(
                        firstName = "Sam",
                        lastName = "Axe"
                )
        )
        vetService.save(
                Vet(
                        firstName = "Sam",
                        lastName = "Hatchet"
                )
        )

        println("Loaded vets.")
    }
}