package com.okproject.flowless.domain.di

import com.okproject.flowless.domain.role.IsRoleRequestedUseCase
import com.okproject.flowless.domain.role.IsRoleRequestedUseCaseImpl
import com.okproject.flowless.domain.role.SetIsRoleRequestedUseCase
import com.okproject.flowless.domain.role.SetIsRoleRequestedUseCaseImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val roleModule = module {
    singleOf(
        ::IsRoleRequestedUseCaseImpl
    ) bind IsRoleRequestedUseCase::class
    singleOf(
        ::SetIsRoleRequestedUseCaseImpl
    ) bind SetIsRoleRequestedUseCase::class
}