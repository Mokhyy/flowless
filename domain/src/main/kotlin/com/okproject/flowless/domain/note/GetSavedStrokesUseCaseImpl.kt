package com.okproject.flowless.domain.note

import com.okproject.flowless.domain.model.stroke.Stroke

class GetSavedStrokesUseCaseImpl(
    private val repository: NoteRepository
): GetSavedStrokesUseCase {
    override suspend fun invoke(): Result<Set<Stroke>> =
        repository.getNoteStrokes()
}