package com.mdaq.sharing.model

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.UniqueConstraint

@Entity
@Table(name = "AWS_PERMISSION",
        uniqueConstraints = [(UniqueConstraint(columnNames = ["USERNAME", "EC2_INSTANCE"]))])
data class AwsPermission(
        @Column(name = "EC2_INSTANCE")
        val ec2Instance: String,

        @Column(name = "USERNAME")
        val username: String,

        @Column(name = "ACCESS_PERMISSION")
        @Enumerated(value = EnumType.STRING)
        val permission: Permission = Permission.VIEW_ONLY,

        @Column(name = "COMMENT")
        val comment: String?,

        @Id
        @GeneratedValue
        @Column(name = "id")
        val id: Long? = null
) : Serializable

enum class Permission {
    VIEW_ONLY, MANAGEMENT
}

fun AwsPermission.toStringForLog(): String {
    return "$username:$permission:$ec2Instance"
}
