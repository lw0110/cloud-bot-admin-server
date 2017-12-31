package com.mdaq.sharing

import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<AwsPermission, Long> {

	fun findByLastName(lastName: String): Iterable<AwsPermission>
}
