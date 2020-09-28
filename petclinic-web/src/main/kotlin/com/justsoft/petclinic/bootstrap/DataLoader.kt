package com.justsoft.petclinic.bootstrap

import com.justsoft.petclinic.models.people.Owner
import com.justsoft.petclinic.models.people.Vet
import com.justsoft.petclinic.models.people.VetSpecialty
import com.justsoft.petclinic.models.pets.Pet
import com.justsoft.petclinic.models.pets.PetType
import com.justsoft.petclinic.services.*
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class DataLoader(
        private val ownerService: OwnerService,
        private val petService: PetService,
        private val vetService: VetService,
        private val petTypeService: PetTypeService,
        private val vetSpecialtyService: VetSpecialtyService,
        private val visitService: VisitService,
) : CommandLineRunner {


    override fun run(vararg args: String?) {
        val count = vetService.findAll().size

        if (count == 0)         // don't add mock data when using persistent storage
            loadData()
    }

    private fun loadData() {
        val dog = PetType("Dog")
        val cat = PetType("Cat")
        val racoon = PetType("Racoon")

        savePetTypes(dog, cat, racoon)

        val ownerMichael = createOwner1()
        val ownerFiona = createOwner2()

        ownerMichael.pets.apply {
            add(Pet("Woofer", dog, LocalDate.now(), ownerMichael))
            add(Pet("Smelly boi", racoon, LocalDate.now(), ownerMichael))
        }

        ownerFiona.pets.apply {
            add(Pet("Barsik", cat, LocalDate.now(), ownerFiona))
            add(Pet("Murzik", cat, LocalDate.now(), ownerFiona))
            add(Pet("Tofu", cat, LocalDate.now(), ownerFiona))
        }

        saveOwners(ownerMichael, ownerFiona)
        println("Loaded owners.")

        val specialtyRadiology = VetSpecialty("Radiology")
        val specialtyDentistry = VetSpecialty("Dentistry")
        val specialtySurgery = VetSpecialty("Surgery")

        saveVetSpecialties(specialtyRadiology, specialtyDentistry, specialtySurgery)

        val vetPick = createVet1()
        val vetSam = createVet2()
        val vetMax = Vet(firstName = "Max", lastName = "Tochot")
        vetPick.specialties.apply {
            add(specialtyRadiology)
            add(specialtySurgery)
        }
        vetSam.specialties.apply {
            add(specialtySurgery)
            add(specialtyDentistry)
        }
        saveVets(vetPick, vetSam, vetMax)
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

    private fun saveVetSpecialties(vararg vetSpecialty: VetSpecialty){
        vetSpecialty.forEach {
            vetSpecialtyService.save(it)
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