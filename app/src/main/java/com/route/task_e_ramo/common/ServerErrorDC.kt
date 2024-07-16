package com.route.task_e_ramo.common

data class ServerErrorDC(
    val stateMessage : Int?=null,
    val serverError : String?=null,
    val httpEx : Throwable?=null
) : Throwable(serverError , httpEx)
