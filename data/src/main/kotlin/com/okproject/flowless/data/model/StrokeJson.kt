package com.okproject.flowless.data.model

import kotlinx.serialization.Serializable

@Serializable
data class StrokeJson(
    val inputs: StrokeInputBatchJson,
    val brush: BrushJson
)
