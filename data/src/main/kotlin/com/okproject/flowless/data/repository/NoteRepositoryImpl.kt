package com.okproject.flowless.data.repository

import com.okproject.flowless.data.datasource.NoteDataSource
import com.okproject.flowless.domain.model.stroke.Stroke
import com.okproject.flowless.domain.note.NoteRepository

class NoteRepositoryImpl(
    private val dataSource: NoteDataSource
) : NoteRepository {
    override suspend fun getNoteStrokes(): Result<Set<Stroke>> =
        dataSource.getNoteStrokes()

    override suspend fun saveNoteStrokes(strokes: Set<Stroke>) {
        dataSource.saveNoteStrokes(strokes)
    }
}