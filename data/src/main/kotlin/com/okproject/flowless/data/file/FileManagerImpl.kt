package com.okproject.flowless.data.file

import android.content.Context
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class FileManagerImpl(
    private val context: Context,
    private val dispatcher: CoroutineDispatcher
): FileManager {
    override suspend fun readFromFile(filename: String): ByteArray =
        withContext(dispatcher) {
            var inputStream: FileInputStream? = null
            try {
                inputStream = context.openFileInput(filename)
                inputStream.readBytes()
            } catch (exception: Exception) {
                throw exception
            } finally {
                inputStream?.close()
            }
    }

    override suspend fun writeToFile(filename: String, fileContent: ByteArray) =
    withContext(dispatcher) {
        var outputStream: FileOutputStream? = null
        try {
            File(context.filesDir, filename).createNewFile()
            outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE)
            outputStream.write(fileContent)
        } catch (exception: Exception) {
            throw exception
        } finally {
            outputStream?.close()
        }
    }
}