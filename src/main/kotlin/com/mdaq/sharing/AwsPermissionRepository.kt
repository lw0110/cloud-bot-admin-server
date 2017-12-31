package com.mdaq.sharing

import org.springframework.data.repository.CrudRepository

interface AwsPermissionRepository : CrudRepository<AwsPermission, Long> {

	fun existsByUsername(username: String): Boolean

}
