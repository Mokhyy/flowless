package com.okproject.flowless.data.datasource

import com.okproject.flowless.domain.model.stroke.Stroke

interface NoteDataSource {
    suspend fun getNoteStrokes(): Result<Set<Stroke>>
    suspend fun saveNoteStrokes(strokes: Set<Stroke>): Result<Unit>
}