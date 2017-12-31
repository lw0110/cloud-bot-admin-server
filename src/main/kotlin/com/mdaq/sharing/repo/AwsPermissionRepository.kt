package com.mdaq.sharing.repo

import com.mdaq.sharing.model.AwsPermission
import org.springframework.data.repository.CrudRepository

interface AwsPermissionRepository : CrudRepository<AwsPermission, Long> {

	fun existsByUsername(username: String): Boolean

}
