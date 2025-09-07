package com.okproject.flowless.domain.note

import com.okproject.flowless.domain.model.stroke.Stroke

class SaveStrokesUseCaseImpl(
    private val repository: NoteRepository
): SaveStrokesUseCase {
    override suspend fun invoke(strokes: Set<Stroke>) =
        repository.saveNoteStrokes(strokes)
}