package com.okproject.flowless.data.file


interface FileManager {
    suspend fun readFromFile(filename: String): ByteArray
    suspend fun writeToFile(filename: String, fileContent: ByteArray)
}