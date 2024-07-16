package com.route.task_e_ramo.utils

data class ViewMessage(
    var title: String? = null,
    var message: String? = null,
    var posBtnTitle: String? = null,
    var onPosBtnClick: (() -> Unit)? = null,
    var onNegBtnClick: (() -> Unit)? = null,
    var negBtnTitle: String? = null,
)
