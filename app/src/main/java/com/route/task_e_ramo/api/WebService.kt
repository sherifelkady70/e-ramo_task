package com.route.task_e_ramo.api

import com.route.task_e_ramo.api.model.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {
    @GET("mobile/broker/{id}/broker")
    suspend fun getBrokerDetails(
        @Path("id") id:String
    ) : Response
}