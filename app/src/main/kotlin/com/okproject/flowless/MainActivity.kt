package com.okproject.flowless

import android.app.role.RoleManager
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.okproject.flowless.editor.NoteEditorScreen
import com.okproject.flowless.role.RoleViewModel
import com.okproject.flowless.ui.theme.FlowlessTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val roleViewModel: RoleViewModel by viewModel()

    private val intentLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            roleViewModel.onRoleRequested()
        }

    private val roleManager: RoleManager by lazy {
        getSystemService(ROLE_SERVICE) as RoleManager
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestNotesRole()
        enableEdgeToEdge()
        setContent {
            FlowlessTheme {
                NoteEditorScreen()
            }
        }
    }

    private fun requestNotesRole() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            requestRole(RoleManager.ROLE_NOTES)
        }
    }

    private fun requestRole(role: String) {
        if (hasToRequestRole(role)) {
            intentLauncher.launch(
                roleManager.createRequestRoleIntent(role)
            )
        }
    }

    private fun hasToRequestRole(role: String): Boolean =
        !roleViewModel.isRoleRequested.value
                && roleManager.isRoleAvailable(role)
                && !roleManager.isRoleHeld(role)
}