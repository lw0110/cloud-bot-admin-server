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
class AwsPermissionControllerTest {

    @Mock private lateinit var awsPermissionService: AwsPermissionService
    private lateinit var awsPermissionController: AwsPermissionController

    @Before
    fun setup() {
        awsPermissionController = AwsPermissionController(awsPermissionService)
    }

    @Test
    fun `should call service get all permissions`() {
        awsPermissionController.getAllAwsPermissions()
        verify(awsPermissionService, times(1)).findAllPermissions()
    }
}