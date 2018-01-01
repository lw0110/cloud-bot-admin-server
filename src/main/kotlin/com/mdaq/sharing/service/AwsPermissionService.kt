package com.mdaq.sharing.service

import com.mdaq.sharing.repo.AwsPermissionRepository
import com.mdaq.sharing.model.AwsPermission
import com.mdaq.sharing.model.Permission
import org.springframework.stereotype.Service

@Service
data class AwsPermissionService(private val awsPermissionRepository: AwsPermissionRepository) {
    fun newAwsPermission(awsPermission: AwsPermission): Long {
        if(awsPermission.id != null) {
            throw RuntimeException("New permission should not have id")
        }
        return awsPermissionRepository.save(awsPermission).id!!
    }

    fun updateAwsPermission(awsPermission: AwsPermission) {
        if(!awsPermissionRepository.existsById(awsPermission.id!!)) {
            throw RuntimeException("Permission with id ${awsPermission.id} exists in db already")
        }
        awsPermissionRepository.save(awsPermission)
    }

    fun deleteAwsPermission(id: Long) {
        awsPermissionRepository.deleteById(id)
    }

    fun findAllPermissions(): List<AwsPermission> = awsPermissionRepository.findAll().toList()

    fun findByInstanceAndUsername(instance: String, username: String): Permission
            = awsPermissionRepository.findByEc2InstanceAndUsername(instance, username).permission
}