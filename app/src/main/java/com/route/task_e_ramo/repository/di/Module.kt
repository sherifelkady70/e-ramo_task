package com.route.task_e_ramo.repository.di

import com.route.task_e_ramo.repository.contract.BrokerRepository
import com.route.task_e_ramo.repository.implementation.BrokerRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class Module {
    @Binds
    abstract fun provideBrokerRepository(impl:BrokerRepositoryImpl)
    :BrokerRepository
}