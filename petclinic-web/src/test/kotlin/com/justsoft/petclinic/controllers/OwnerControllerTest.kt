package com.justsoft.petclinic.controllers

import com.justsoft.petclinic.models.people.Owner
import com.justsoft.petclinic.models.people.owner
import com.justsoft.petclinic.services.OwnerService
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verifyNoInteractions
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(MockitoExtension::class)
internal class OwnerControllerTest {

    @Mock
    private lateinit var ownerService: OwnerService

    @InjectMocks
    private lateinit var ownerController: OwnerController

    private lateinit var mockMvc: MockMvc

    private val owners = setOf(
            owner {
                firstName = "Max"
                lastName = "Maxish"
                id = 3
            },
            owner {
                firstName = "Max"
                lastName = "Maxish2"
                id = 4
            }
    )

    @BeforeEach
    fun setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build()
    }

    @Test
    fun listOwners() {
        `when`(ownerService.findAll()).thenReturn(owners)

        mockMvc.get("/owners").andExpect {
            status { isOk }
            view { name("owners/index") }
            model { attribute("owners", hasSize<Owner>(2)) }
        }
    }

    @Test
    fun listOwnersByIndex() {
        `when`(ownerService.findAll()).thenReturn(owners)

        mockMvc.get("/owners/index").andExpect {
            status { isOk }
            view { name("owners/index") }
            model { attribute("owners", hasSize<Owner>(2)) }
        }
    }

    @Test
    fun findOwners() {
        mockMvc.get("/owners/find").andExpect {
            view { name("not_implemented") }
        }
        verifyNoInteractions(ownerService)
    }
}