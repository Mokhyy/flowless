package com.okproject.flowless.data.mapper

import com.okproject.flowless.data.model.BrushJson
import com.okproject.flowless.domain.model.brush.Brush

fun BrushJson.toBrush() = Brush(
    size = this.size,
    color = this.color,
    epsilon = this.epsilon,
    brushType = BrushTypeStringMapper.mapToBrushType(this.brushType)
)

fun Brush.toJson() = BrushJson(
    size = this.size,
    color = this.color,
    epsilon = this.epsilon,
    brushType = BrushTypeStringMapper.mapToString(this.brushType)
)