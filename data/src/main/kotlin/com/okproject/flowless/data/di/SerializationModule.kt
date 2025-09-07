package com.okproject.flowless.data.di

import kotlinx.serialization.json.Json
import org.koin.dsl.bind
import org.koin.dsl.module

val serializationModule = module {
    single {
        Json {
            isLenient = true
            prettyPrint = true
            ignoreUnknownKeys = true
        }
    } bind Json::class
}