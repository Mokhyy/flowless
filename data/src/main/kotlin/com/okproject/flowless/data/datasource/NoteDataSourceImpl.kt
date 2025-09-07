package com.okproject.flowless.data.datasource

import com.okproject.flowless.data.mapper.toJson
import com.okproject.flowless.data.mapper.toStroke
import com.okproject.flowless.data.storage.NoteStorage
import com.okproject.flowless.domain.model.stroke.Stroke

class NoteDataSourceImpl(
    private val storage: NoteStorage
): NoteDataSource {
    override suspend fun getNoteStrokes(): Result<Set<Stroke>> =
        storage.getNoteStrokes().map {
            it.map { strokeJson -> strokeJson.toStroke() }.toSet()
        }

    override suspend fun saveNoteStrokes(strokes: Set<Stroke>): Result<Unit> =
        storage.saveNoteStrokes(strokes.map {it.toJson()}.toSet())
}