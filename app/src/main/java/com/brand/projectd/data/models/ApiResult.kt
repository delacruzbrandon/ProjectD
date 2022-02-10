package com.brand.projectd.data.models

import com.google.gson.annotations.SerializedName

data class ApiResult(
    @SerializedName("resultCount")
    var trackCount: Int,

    @SerializedName("results")
    var trackList: List<Track>
)