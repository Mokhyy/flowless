package com.okproject.flowless.data.di

import com.okproject.flowless.data.repository.BrushRepositoryImpl
import com.okproject.flowless.data.repository.NoteRepositoryImpl
import com.okproject.flowless.data.repository.RoleRepositoryImpl
import com.okproject.flowless.domain.brush.BrushRepository
import com.okproject.flowless.domain.note.NoteRepository
import com.okproject.flowless.domain.role.RoleRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(
        ::RoleRepositoryImpl
    ) bind RoleRepository::class
    singleOf(
        ::BrushRepositoryImpl
    ) bind BrushRepository::class
    singleOf(
        ::NoteRepositoryImpl
    ) bind NoteRepository::class
}