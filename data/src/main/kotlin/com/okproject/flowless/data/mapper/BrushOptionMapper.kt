package com.okproject.flowless.data.mapper

import com.okproject.flowless.data.model.BrushOption
import com.okproject.flowless.domain.model.brush.Brush

internal fun BrushOption.mapToBrush(): Brush =
    Brush(
        size = this.size,
        color = this.color,
        epsilon = this.epsilon,
        brushType = BrushTypeOptionMapper.mapToType(this.type)
    )
