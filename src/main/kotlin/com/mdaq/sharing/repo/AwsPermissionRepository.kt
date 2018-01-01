package com.mdaq.sharing.repo

import com.mdaq.sharing.model.AwsPermission
import org.springframework.data.repository.CrudRepository

interface AwsPermissionRepository : CrudRepository<AwsPermission, Long> {

	fun findByEc2InstanceAndUsername(instance: String, username: String): AwsPermission

}
