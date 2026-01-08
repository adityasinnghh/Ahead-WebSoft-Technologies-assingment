package com.example.navigationdrawer





import com.google.gson.annotations.SerializedName


data class NavigationResponse(
    @SerializedName("result")
    val result: ResultData?
)

data class ResultData(
    @SerializedName("menus")
    val menus: List<MenuItem>?
)

data class MenuItem(
    @SerializedName("type")
    val type: Int?,          // 0 = section header, 1 = actual item

    @SerializedName("label")
    val label: String?,

    @SerializedName("icon")
    val icon: String?
)
