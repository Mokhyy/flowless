package com.okproject.flowless.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StrokeInputJson(
    val x: Float,
    val y: Float,
    @SerialName("time_millis")
    val timeMillis: Long,
    val pressure: Float,
    @SerialName("tilt_radians")
    val tiltRadians: Float,
    @SerialName("orientation_radians")
    val orientationRadians: Float,
    @SerialName("stroke_unit_length_cm")
    val strokeUnitLengthCm: Float
)
