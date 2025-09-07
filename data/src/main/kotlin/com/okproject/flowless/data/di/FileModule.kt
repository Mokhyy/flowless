package com.okproject.flowless.data.di

import com.okproject.flowless.data.file.FileManager
import com.okproject.flowless.data.file.FileManagerImpl
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val fileModule = module {
    single {
        FileManagerImpl(
            context = get(),
            dispatcher = get(named(IO_DISPATCHER))
        )
    } bind FileManager::class
}