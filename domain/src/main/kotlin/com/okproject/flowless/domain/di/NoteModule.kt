package com.okproject.flowless.domain.di

import com.okproject.flowless.domain.note.GetSavedStrokesUseCase
import com.okproject.flowless.domain.note.GetSavedStrokesUseCaseImpl
import com.okproject.flowless.domain.note.SaveStrokesUseCase
import com.okproject.flowless.domain.note.SaveStrokesUseCaseImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val noteModule = module {
    singleOf(
        ::GetSavedStrokesUseCaseImpl
    ) bind GetSavedStrokesUseCase::class
    singleOf(
        ::SaveStrokesUseCaseImpl
    ) bind SaveStrokesUseCase::class
}