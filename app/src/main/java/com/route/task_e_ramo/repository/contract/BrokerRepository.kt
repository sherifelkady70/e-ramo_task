package com.route.task_e_ramo.repository.contract

import com.route.task_e_ramo.api.model.DataItem
import com.route.task_e_ramo.common.Resource
import kotlinx.coroutines.flow.Flow

interface BrokerRepository {
    suspend fun getBrokerDetails(id:String):Flow<Resource<List<DataItem?>?>>
}