package com.okproject.flowless.domain.note

import com.okproject.flowless.domain.model.stroke.Stroke

interface NoteRepository {
    suspend fun getNoteStrokes(): Result<Set<Stroke>>
    suspend fun saveNoteStrokes(strokes: Set<Stroke>)
}