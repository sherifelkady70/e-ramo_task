package com.route.task_e_ramo.api.model

data class Response(
	val data: List<DataItem?>? = null,
	val message: String? = null,
	val status: Int? = null
)
data class ProjectsItem(
	val image: String? = null,
	val country: String? = null,
	val listingNumber: String? = null,
	val priceFrom: String? = null,
	val city: String? = null,
	val facebook: String? = null,
	val description: String? = null,
	val createdAt: String? = null,
	val googlePlus: String? = null,
	val title: String? = null,
	val bedrooms: String? = null,
	val deliveryDate: Any? = null,
	val twitter: String? = null,
	val agentData: AgentData? = null,
	val id: Int? = null,
	val totalUnits: String? = null,
	val region: String? = null
)
data class AgentData(
	val propertiesCount: Int? = null,
	val phone: String? = null,
	val name: String? = null,
	val logo: String? = null,
	val projectsCount: Int? = null,
	val brokerType: String? = null,
	val description: String? = null,
	val id: Int? = null,
	val email: String? = null
)
data class DataItem(
	val projects: List<ProjectsItem?>? = null,
	val phone: String? = null,
	val propertyForRent: Int? = null,
	val name: String? = null,
	val propertyForSale: Int? = null,
	val logo: String? = null,
	val projectsCount: Int? = null,
	val brokerType: String? = null,
	val description: String? = null,
	val id: Int? = null,
	val email: String? = null,
	val hasPackage: String? = null
)
