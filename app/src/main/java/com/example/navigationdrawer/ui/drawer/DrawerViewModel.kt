package com.example.navigationdrawer.ui.drawer

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigationdrawer.MenuItem
import com.example.navigationdrawer.data.repository.NavigationRepository
import kotlinx.coroutines.launch

class DrawerViewModel : ViewModel() {

    private val repository = NavigationRepository()

    var menuSections by mutableStateOf<Map<String, List<MenuItem>>>(emptyMap())
        private set

    // Controls Apps expand / collapse
    var appsExpanded by mutableStateOf(false)
        private set

    companion object {
        private const val TAG = "DrawerViewModel"
    }

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val response = repository.fetchNavigation()
            Log.d(TAG, "FULL RESPONSE: $response")

            val menus = response.result?.menus ?: emptyList()
            menuSections = splitIntoSections(menus)
        }
    }

    private fun splitIntoSections(
        menus: List<MenuItem>
    ): Map<String, List<MenuItem>> {

        val sections = linkedMapOf<String, MutableList<MenuItem>>()
        var currentSection = "MAIN"

        menus.forEach { item ->
            if (item.type == 0) {
                currentSection = item.label ?: "OTHER"
                sections[currentSection] = mutableListOf()
            } else {
                sections
                    .getOrPut(currentSection) { mutableListOf() }
                    .add(item)
            }
        }
        return sections
    }

    fun toggleApps() {
        appsExpanded = !appsExpanded
    }
}
