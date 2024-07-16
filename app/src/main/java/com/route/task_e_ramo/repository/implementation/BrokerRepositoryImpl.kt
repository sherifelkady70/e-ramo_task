package com.route.task_e_ramo.repository.implementation

import com.route.task_e_ramo.api.WebService
import com.route.task_e_ramo.api.model.DataItem
import com.route.task_e_ramo.common.Resource
import com.route.task_e_ramo.repository.contract.BrokerRepository
import com.route.task_e_ramo.utils.executeAPI
import com.route.task_e_ramo.utils.toFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BrokerRepositoryImpl @Inject constructor(
    private val webService  : WebService
): BrokerRepository {
    override suspend fun getBrokerDetails(id:String): Flow<Resource<List<DataItem?>?>> {
       val response = executeAPI { webService.getBrokerDetails(id) }
        return toFlow { response.data }
    }
}