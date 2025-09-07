package com.okproject.flowless.data.mapper

import com.okproject.flowless.data.ext.enumValueOfOrNull
import com.okproject.flowless.data.model.StrokeInputBatchJson
import com.okproject.flowless.data.model.StrokeInputJson
import com.okproject.flowless.data.model.StrokeJson
import com.okproject.flowless.domain.model.stroke.Stroke
import com.okproject.flowless.domain.model.stroke.StrokeInput
import com.okproject.flowless.domain.model.stroke.StrokeInputBatch
import com.okproject.flowless.domain.model.stroke.ToolType

fun StrokeJson.toStroke() = Stroke(
    inputs = this.inputs.toStrokeInputBatch(),
    brush = this.brush.toBrush()
)

fun StrokeInputBatchJson.toStrokeInputBatch() = StrokeInputBatch(
    toolType = enumValueOfOrNull<ToolType>(this.toolType) ?: ToolType.UNKNOWN,
    strokeUnitLengthCm = this.strokeUnitLengthCm,
    inputs = this.inputs.map { it.toStrokeInput() }
)

fun StrokeInputJson.toStrokeInput() = StrokeInput(
    x = this.x,
    y = this.y,
    timeMillis = timeMillis,
    pressure = this.pressure,
    tiltRadians = this.tiltRadians,
    orientationRadians = this.orientationRadians,
    strokeUnitLengthCm = this.strokeUnitLengthCm
)

fun Stroke.toJson() = StrokeJson(
    inputs = this.inputs.toJson(),
    brush = this.brush.toJson()
)

fun StrokeInputBatch.toJson() = StrokeInputBatchJson(
    toolType = this.toolType.name,
    strokeUnitLengthCm = this.strokeUnitLengthCm,
    inputs = this.inputs.map { it.toJson() }
)

fun StrokeInput.toJson() = StrokeInputJson(
    x = this.x,
    y = this.y,
    timeMillis = timeMillis,
    pressure = this.pressure,
    tiltRadians = this.tiltRadians,
    orientationRadians = this.orientationRadians,
    strokeUnitLengthCm = this.strokeUnitLengthCm
)