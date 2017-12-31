package com.mdaq.sharing

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "AWS_PERMISSION")
data class AwsPermission(
        @Column(name = "EC2_INSTANCE")
		val ec2Instance: String,

        @Column(name = "USERNAME")
		val username: String,

        @Column(name = "ACCESS_PERMISSION")
        @Enumerated(value = EnumType.STRING)
        val permission: Permission,

		@Id
        @GeneratedValue
        @Column(name = "id")
		val id: Long
)

enum class Permission {
    VIEW_ONLY, MANAGEMENT
}
