package com.route.task_e_ramo.acivity.fargment.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.task_e_ramo.api.model.ProjectsItem
import com.route.task_e_ramo.common.InternetConnection
import com.route.task_e_ramo.common.Resource
import com.route.task_e_ramo.repository.contract.BrokerRepository
import com.route.task_e_ramo.utils.ViewMessage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsFragmentViewModel @Inject constructor(
    private val brokerRepository : BrokerRepository
): ViewModel() {
    var loading = MutableLiveData<Boolean>()
    var viewMessage = MutableLiveData<ViewMessage>()
    var name = MutableStateFlow<String?>("")
    var description = MutableStateFlow<String?>("")
    var logo = MutableStateFlow<String?>("")
    var projectItemList = MutableStateFlow<List<ProjectsItem?>?>(listOf<ProjectsItem>())
    fun getBrokerDetails(id:String) {
        viewModelScope.launch(Dispatchers.IO) {
            brokerRepository.getBrokerDetails(id).collect{ resource ->
                when(resource){
                    is Resource.Success ->{
                        name.value = resource.data?.get(0)?.name
                        description.value = resource.data?.get(0)?.description
                        logo.value = resource.data?.get(0)?.logo
                        projectItemList.value = resource.data?.get(0)?.projects
                    }
                    else ->{
                        handleResource(resource)
                    }
                }
            }
        }
    }
    private fun <T>handleResource(resource : Resource<T>){
        when(resource) {
            is Resource.Fail -> {
                when(resource.error){
                    is InternetConnection -> {
                        viewMessage.postValue(ViewMessage(
                            resource.error.message
                        ))
                    }
                    else ->{
                        viewMessage.postValue(ViewMessage(
                            resource.error.localizedMessage
                        ))
                    }
                }
            }
            is Resource.ServerError -> {
                viewMessage.postValue(ViewMessage(
                    resource.message.serverError
                ))
            }
            is Resource.Loading ->{
                loading.postValue(true)
            }
            else -> null
        }
    }
}