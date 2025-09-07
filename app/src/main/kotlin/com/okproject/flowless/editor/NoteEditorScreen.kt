package com.okproject.flowless.editor

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.okproject.flowless.R
import com.okproject.flowless.mapper.BrushMapper
import com.okproject.flowless.mapper.BrushTypeMapper
import com.okproject.flowless.mapper.StrokeMapper
import com.okproject.flowless.ui.component.inkcanvas.InkCanvas
import com.okproject.flowless.ui.component.progress.InfiniteProgressIndicator
import com.okproject.flowless.ui.theme.Dimens
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteEditorScreen(
    modifier: Modifier = Modifier,
    noteEditorViewModel: NoteEditorViewModel = koinViewModel()
) {
    val isLoading by noteEditorViewModel.isLoadingState.collectAsStateWithLifecycle()
    val brush by noteEditorViewModel.brush.collectAsStateWithLifecycle()
    val finishedStrokes by noteEditorViewModel.finishedStrokes.collectAsStateWithLifecycle()

    val bottomSheetScaffoldState: BottomSheetScaffoldState = rememberBottomSheetScaffoldState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            SaveButton(
                visible = !isLoading,
                onSaveClicked = noteEditorViewModel::saveNote
            )
        }
    ) { innerPadding ->
        BottomSheetScaffold(
            modifier = modifier.padding(top = innerPadding.calculateTopPadding()),
            scaffoldState = bottomSheetScaffoldState,
            sheetShape = RoundedCornerShape(
                topStart = Dimens.bottomSheetTopCornerRadius,
                topEnd = Dimens.bottomSheetTopCornerRadius
            ),
            sheetContent = {
                BrushSettingsSheet(
                    modifier = Modifier.padding(vertical = Dimens.defaultPadding),
                    selectedBrushType = brush.brushType,
                    brushTypes = BrushTypeMapper.mapToChipItems(noteEditorViewModel.brushTypes),
                    onBrushTypeSelected = noteEditorViewModel::onBrushTypeSelected,
                    selectedBrushSize = brush.size,
                    brushSizeRange = noteEditorViewModel.brushSizeRange,
                    onBrushSizeChanged = noteEditorViewModel::onBrushSizeChanged,
                    brushColor = brush.color,
                    onBrushColorChanged = noteEditorViewModel::onBrushColorChanged
                )
            },
        ) { bottomSheetPadding ->
            if (isLoading) {
                InfiniteProgressIndicator(
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                InkCanvas(
                    brush = BrushMapper.mapToInkBrush(brush),
                    initialFinishedStrokes = StrokeMapper.mapToInkStrokes(finishedStrokes),
                    onStrokeFinished = {
                        noteEditorViewModel.onStrokeFinished(StrokeMapper.mapToStrokes(it))
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = bottomSheetPadding.calculateBottomPadding())
                )
            }
        }
    }
}

@Composable
private fun SaveButton(
    visible: Boolean,
    onSaveClicked: () -> Unit
) {
    if (visible) {
        FloatingActionButton(
            onClick = onSaveClicked
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_save),
                contentDescription = stringResource(R.string.save)
            )
        }
    }
}