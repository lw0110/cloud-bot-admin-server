package com.mdaq.sharing

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AwsPermissionController(private val repository: AwsPermissionRepository) {

	@GetMapping("/aws-permission")
	fun getAllAwsPermissions(): List<AwsPermission>
    = repository.findAll().toList()
}