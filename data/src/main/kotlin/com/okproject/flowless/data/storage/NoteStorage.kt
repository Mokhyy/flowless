package com.okproject.flowless.data.storage

import com.okproject.flowless.data.model.StrokeJson

interface NoteStorage {
    suspend fun getNoteStrokes(): Result<Set<StrokeJson>>
    suspend fun saveNoteStrokes(strokes: Set<StrokeJson>): Result<Unit>
}