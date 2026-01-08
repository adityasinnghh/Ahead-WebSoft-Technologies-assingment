package com.example.navigationdrawer.data.api

import com.example.navigationdrawer.NavigationResponse

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("sesapi/navigation")
    suspend fun getNavigation(
        @Query("restApi") restApi: String = "Sesapi",
        @Query("sesapi_platform") platform: Int = 1,
        @Query("auth_token") token: String
    ): NavigationResponse


}
