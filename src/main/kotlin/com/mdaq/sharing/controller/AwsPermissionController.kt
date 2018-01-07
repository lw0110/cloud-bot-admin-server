package com.mdaq.sharing.controller

import com.mdaq.sharing.model.AwsPermission
import com.mdaq.sharing.model.Permission
import com.mdaq.sharing.model.toStringForLog
import com.mdaq.sharing.service.AwsPermissionService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class AwsPermissionController(private val awsPermissionService: AwsPermissionService) {

    companion object {
        val LOGGER = KotlinLogging.logger {  }
    }

	@GetMapping("/aws-permission")
	fun getAllAwsPermissions(): List<AwsPermission> = awsPermissionService.findAllPermissions()

    @PostMapping("/aws-permission")
    fun newAwsPermission(@RequestBody awsPermission: AwsPermission): Long {
        LOGGER.info { "Receiving new aws permission post request with ${awsPermission.toStringForLog()}" }
        return awsPermissionService.newAwsPermission(awsPermission)
    }

    @PutMapping("/aws-permission")
    fun updateAwsPermission(@RequestBody awsPermission: AwsPermission) {
        LOGGER.info { "Receiving update aws permission post request with ${awsPermission.toStringForLog()}" }
        awsPermissionService.updateAwsPermission(awsPermission)
    }

    @DeleteMapping("/aws-permission/{id}")
    fun deleteAwsPermission(@PathVariable id: Long) {
        LOGGER.info { "Receiving delete aws permission for id $id" }
        awsPermissionService.deleteAwsPermission(id)
    }

    @GetMapping("/get-permission")
    fun getPermissionByInstanceAndUsername(@RequestParam instance: String, @RequestParam username: String): Permission? {
        LOGGER.info { "Receiving get request to get permissions by instance $instance and username $username" }
        return awsPermissionService.findByInstanceAndUsername(instance, username)
    }

}