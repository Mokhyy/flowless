package com.okproject.flowless.data.mapper

import com.okproject.flowless.data.model.BrushJson
import com.okproject.flowless.domain.model.brush.BrushType

object BrushTypeStringMapper {
    private val brushTypeToString = mapOf(
        BrushType.PRESSURE_PEN_V1 to BrushJson.PRESSURE_PEN_V1,
        BrushType.MARKER_V1 to BrushJson.MARKER_V1,
        BrushType.HIGHLIGHTER_V1 to BrushJson.HIGHLIGHTER_V1,
        BrushType.DASHED_LINE_V1 to BrushJson.DASHED_LINE_V1
    )
    private val stringToBrushType =
        brushTypeToString.entries.associate { (key, value) -> value to key }

    fun mapToBrushType(type: String) =
        stringToBrushType[type] ?: BrushType.PRESSURE_PEN_V1

    fun mapToString(type: BrushType) =
        brushTypeToString[type] ?: BrushJson.PRESSURE_PEN_V1

}