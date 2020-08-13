package com.justsoft.petclinic.bootstrap

import com.justsoft.petclinic.models.Owner
import com.justsoft.petclinic.models.Vet
import com.justsoft.petclinic.services.OwnerService
import com.justsoft.petclinic.services.PetService
import com.justsoft.petclinic.services.VetService
import com.justsoft.petclinic.services.map.OwnerServiceMap
import com.justsoft.petclinic.services.map.PetServiceMap
import com.justsoft.petclinic.services.map.VetServiceMap
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataLoader : CommandLineRunner {

    private val ownerService: OwnerService = OwnerServiceMap()
    private val petService: PetService = PetServiceMap()
    private val vetService: VetService = VetServiceMap()

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