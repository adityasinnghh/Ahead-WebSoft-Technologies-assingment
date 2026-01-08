package com.example.navigationdrawer.data.repository


import com.example.navigationdrawer.NavigationResponse

import com.example.navigationdrawer.data.api.RetrofitClient

class NavigationRepository {

    suspend fun fetchNavigation(): NavigationResponse {
        return RetrofitClient.api.getNavigation(
            token = "B179086bb56c32731633335762"
        )
    }
}
