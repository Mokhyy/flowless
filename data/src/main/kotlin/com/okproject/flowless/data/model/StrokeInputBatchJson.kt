package com.okproject.flowless.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StrokeInputBatchJson(
    @SerialName("tool_type")
    val toolType: String,
    @SerialName("stroke_unit_length_cm")
    val strokeUnitLengthCm: Float,
    val inputs: List<StrokeInputJson>
)
