package com.okproject.flowless.data.storage

import com.okproject.flowless.data.file.FileManager
import com.okproject.flowless.data.model.StrokeJson
import kotlinx.serialization.json.Json

class NoteStorageImpl(
    private val fileManager: FileManager,
    private val json: Json
): NoteStorage {
    override suspend fun getNoteStrokes(): Result<Set<StrokeJson>> =
        try {
            val strokesJsonString = fileManager.readFromFile(NOTE_FILE_NAME).toString()
            val strokes = json.decodeFromString<List<StrokeJson>>(strokesJsonString).toSet()
            Result.success(strokes)
        } catch (exception: Exception) {
            Result.failure(exception)
        }

    override suspend fun saveNoteStrokes(strokes: Set<StrokeJson>): Result<Unit> =
        try {
            val strokesByteArray = json.encodeToString(strokes).toByteArray()
            fileManager.writeToFile(NOTE_FILE_NAME, strokesByteArray)
            Result.success(Unit)
        } catch (exception: Exception) {
            Result.failure(exception)
        }

    companion object {
        private const val NOTE_FILE_NAME = "temp_note.json"
    }
}