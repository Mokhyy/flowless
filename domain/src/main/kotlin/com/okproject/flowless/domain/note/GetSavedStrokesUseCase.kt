package com.okproject.flowless.domain.note

import com.okproject.flowless.domain.model.stroke.Stroke

interface GetSavedStrokesUseCase {
    suspend operator fun invoke(): Result<Set<Stroke>>
}