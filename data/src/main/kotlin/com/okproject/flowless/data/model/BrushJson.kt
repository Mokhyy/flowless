package com.okproject.flowless.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BrushJson(
    val size: Float,
    val color: Long,
    val epsilon: Float,
    @SerialName("brush_type")
    val brushType: String
) {
    companion object Type {
        const val PRESSURE_PEN_V1 = "pressure_pen_v1"
        const val MARKER_V1 = "marker_v1"
        const val HIGHLIGHTER_V1 = "highlighter_v1"
        const val DASHED_LINE_V1 = "dashed_line_v1"
    }
}
