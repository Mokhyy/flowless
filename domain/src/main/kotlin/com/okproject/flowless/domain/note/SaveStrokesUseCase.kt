package com.okproject.flowless.domain.note

import com.okproject.flowless.domain.model.stroke.Stroke

interface SaveStrokesUseCase {
    suspend operator fun invoke(strokes: Set<Stroke>)
}