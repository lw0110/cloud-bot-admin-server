package com.mdaq.sharing.repo

import com.mdaq.sharing.model.AwsPermission
import com.mdaq.sharing.model.Permission
import org.springframework.data.repository.CrudRepository

    interface AwsPermissionRepository : CrudRepository<AwsPermission, Long> {

        fun findByEc2InstanceAndUsername(instance: String, username: String): AwsPermission?

        fun findByPermission(permission: Permission): List<AwsPermission>

    }
