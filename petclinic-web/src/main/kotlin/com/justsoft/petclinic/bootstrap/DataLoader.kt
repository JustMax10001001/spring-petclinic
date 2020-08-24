package com.justsoft.petclinic.bootstrap

import com.justsoft.petclinic.models.people.Owner
import com.justsoft.petclinic.models.people.vet.Vet
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
                Owner().apply {
                    firstName = "Michael"
                    lastName = "Weston"
                }
        )
        ownerService.save(
                Owner().apply {
                    firstName = "Fiona"
                    lastName = "Shreck"
                }
        )

        println("Loaded owners.")

        vetService.save(
                Vet().apply {
                    firstName = "Sam"
                    lastName = "Axe"
                }
        )
        vetService.save(
                Vet().apply {
                    firstName = "Sam"
                    lastName = "Hatchet"
                }
        )

        println("Loaded vets.")
    }
}