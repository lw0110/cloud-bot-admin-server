package com.mdaq.sharing

import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CustomerControllerTest {

    @Mock private lateinit var customerRepository: AwsPermissionRepository
    private lateinit var customerController: AwsPermissionController

    @Before
    fun setup() {
        customerController = AwsPermissionController(customerRepository)
    }

//    @Test
//    fun `should call repository through controller`() {
//        customerController.findByLastName("John")
//        argumentCaptor<String>().apply {
//            verify(customerRepository, times(1)).findByLastName(capture())
//            Assert.assertThat(firstValue, CoreMatchers.equalTo("John"))
//        }
//    }
}