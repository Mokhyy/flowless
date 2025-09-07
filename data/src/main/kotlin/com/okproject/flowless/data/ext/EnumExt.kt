package com.okproject.flowless.data.ext

inline fun <reified T : Enum<T>> enumValueOfOrNull(name: String): T? =
    runCatching { enumValueOf<T>(name) }.getOrNull()