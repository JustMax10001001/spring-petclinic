package com.justsoft.petclinic.bootstrap

import com.justsoft.petclinic.models.people.Owner
import com.justsoft.petclinic.models.people.Vet
import com.justsoft.petclinic.models.pets.Pet
import com.justsoft.petclinic.models.pets.PetType
import com.justsoft.petclinic.services.OwnerService
import com.justsoft.petclinic.services.PetService
import com.justsoft.petclinic.services.PetTypeService
import com.justsoft.petclinic.services.VetService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DataLoader(
        private val ownerService: OwnerService,
        private val petService: PetService,
        private val vetService: VetService,
        private val petTypeService: PetTypeService,
) : CommandLineRunner {


    override fun run(vararg args: String?) {
        val dog = PetType("Dog")
        val cat = PetType("Cat")
        val racoon = PetType("Racoon")
        savePetTypes(dog, cat, racoon)
        println("Loaded pet types")

        val ownerMichael = createOwner1()
        val ownerFiona = createOwner2()
        saveOwners(ownerMichael, ownerFiona)
        println("Loaded owners.")

        val vetPick = createVet1()
        val vetSam = createVet2()
        saveVets(vetPick, vetSam)
        println("Loaded vets.")
    }

    private fun savePets(vararg pets: Pet) {
        pets.forEach {
            petService.save(it)
        }
    }

    private fun saveVets(vararg vets: Vet) {
        vets.forEach {
            vetService.save(it)
        }
    }

    private fun savePetTypes(vararg petTypes: PetType) {
        petTypes.forEach {
            petTypeService.save(it)
        }
    }

    private fun saveOwners(vararg owners: Owner) {
        owners.forEach {
            ownerService.save(it)
        }
    }

    private fun createVet1(): Vet = Vet(
            firstName = "Pick",
            lastName = "Axe",
    )

    private fun createVet2(): Vet = Vet(
            firstName = "Sam",
            lastName = "Hatchet",
    )

    private fun createOwner1(): Owner = Owner(
            firstName = "Michael",
            lastName = "Weston",
            address = "Kulparkivska",
            city = "Lviv",
            telephone = "0223352"
    )

    private fun createOwner2(): Owner = Owner(
            firstName = "Fiona",
            lastName = "Shrek",
            address = "Uzhgorodska",
            city = "Lviv",
            telephone = "0223351"
    )
}