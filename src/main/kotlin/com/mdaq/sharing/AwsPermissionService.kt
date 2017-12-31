package com.mdaq.sharing

import org.springframework.stereotype.Service

@Service
data class AwsPermissionService(val awsPermissionRepository: AwsPermissionRepository) {
    fun newAwsPermission(awsPermission: AwsPermission): Long {
        if(awsPermission.id != null) {
            throw RuntimeException("New permission should not have id")
        }
        return awsPermissionRepository.save(awsPermission).id!!
    }

    fun updateAwsPersmission(awsPermission: AwsPermission) {
        if(!awsPermissionRepository.existsById(awsPermission.id!!)) {
            throw RuntimeException("Permission with id ${awsPermission.id} exists in db already")
        }
        awsPermissionRepository.save(awsPermission)
    }

    fun deleteAwsPermission(id: Long) {
        awsPermissionRepository.deleteById(id)
    }

    fun findAllPermissions(): List<AwsPermission> = awsPermissionRepository.findAll().toList()
}