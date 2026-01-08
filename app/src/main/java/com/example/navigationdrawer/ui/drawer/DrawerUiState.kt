package com.example.navigationdrawer.ui.drawer

import com.example.navigationdrawer.NavigationResponse


/**
 * Represents UI state for Navigation Drawer
 * Helps in handling Loading, Success, and Error cases cleanly
 */
sealed class DrawerUiState {

    /**
     * Initial & loading state
     */
    object Loading : DrawerUiState()

    /**
     * Success state when API data is received
     */
    data class Success(
        val data: NavigationResponse
    ) : DrawerUiState()

    /**
     * Error state if API fails
     */
    data class Error(
        val message: String
    ) : DrawerUiState()
}
