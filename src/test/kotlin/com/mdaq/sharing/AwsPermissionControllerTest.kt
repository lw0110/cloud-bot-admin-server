package com.mdaq.sharing

import com.mdaq.sharing.controller.AwsPermissionController
import com.mdaq.sharing.model.AwsPermission
import com.mdaq.sharing.model.Permission
import com.mdaq.sharing.service.AwsPermissionService
import com.nhaarman.mockitokotlin2.argumentCaptor
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AwsPermissionControllerTest {

    companion object {
        val TEST_INSTANCE = "TEST_INSTANCE"
        val TEST_USERNAME = "USERNAME"
        val TEST_PERMISSION = Permission.VIEW_ONLY
        val TEST_AWS_PERMISSION = AwsPermission(TEST_INSTANCE, TEST_USERNAME, TEST_PERMISSION)
    }

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

    @Test
    fun `should create permission by calling through service`() {
        awsPermissionController.newAwsPermission(TEST_AWS_PERMISSION)
        argumentCaptor<AwsPermission>().apply {
            verify(awsPermissionService, times(1)).newAwsPermission(capture())
            with(firstValue) {
                assertThat(ec2Instance, equalTo(TEST_INSTANCE))
                assertThat(username, equalTo(TEST_USERNAME))
                assertThat(permission, equalTo(TEST_PERMISSION))
            }
        }
    }
}