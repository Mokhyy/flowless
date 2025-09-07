package com.okproject.flowless.data.di

import com.okproject.flowless.data.storage.BrushStorage
import com.okproject.flowless.data.storage.BrushStorageImpl
import com.okproject.flowless.data.storage.NoteStorage
import com.okproject.flowless.data.storage.NoteStorageImpl
import com.okproject.flowless.data.storage.RoleStorage
import com.okproject.flowless.data.storage.RoleStorageImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val storageModule = module {
    singleOf(
        ::RoleStorageImpl
    ) bind RoleStorage::class
    singleOf(
        ::BrushStorageImpl
    ) bind BrushStorage::class
    singleOf(
        ::NoteStorageImpl
    ) bind NoteStorage::class
}