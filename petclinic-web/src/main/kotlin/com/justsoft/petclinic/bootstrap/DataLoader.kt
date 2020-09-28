package com.justsoft.petclinic.bootstrap

import com.justsoft.petclinic.models.people.*
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

        val ownerMichael = owner {
            firstName = "Michael"
            lastName = "Weston"
            address = "Kulparkivska"
            city = "Lviv"
            telephone = "0223352"


            pet(dog) {
                name = "Woofer"
                birthDate = LocalDate.now()
            }
            pet(racoon) {
                name = "Smelly boi"
                birthDate = LocalDate.now()
            }
        }

        val ownerFiona = owner {
            firstName = "Fiona"
            lastName = "Shrek"
            address = "Uzhgorodska"
            city = "Lviv"
            telephone = "0223351"

            pet(cat) {
                name = "Barsik"
                birthDate = LocalDate.now()
            }
            pet(cat) {
                name = "Murzik"
                birthDate = LocalDate.now()
            }
            pet(cat) {
                name = "Tofu"
                birthDate = LocalDate.now()
            }
        }

        saveOwners(ownerMichael, ownerFiona)
        println("Loaded owners.")

        val specialtyRadiology = VetSpecialty("Radiology")
        val specialtyDentistry = VetSpecialty("Dentistry")
        val specialtySurgery = VetSpecialty("Surgery")

        saveVetSpecialties(specialtyRadiology, specialtyDentistry, specialtySurgery)

        val vetPick = vet {
            firstName = "Pick"
            lastName = "Axe"

            specialty(specialtyRadiology)
            specialty(specialtySurgery)
        }
        val vetSam = vet {
            firstName = "Sam"
            lastName = "Hatchet"

            specialty(specialtySurgery)
            specialty(specialtyDentistry)
        }
        val vetMax = vet {
            firstName = "Max"
            lastName = "Tochot"
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

    private fun saveVetSpecialties(vararg vetSpecialty: VetSpecialty) {
        vetSpecialty.forEach {
            vetSpecialtyService.save(it)
        }
    }
}