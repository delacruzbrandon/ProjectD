package com.brand.projectd.data.service

import com.brand.projectd.data.models.ApiResult
import com.brand.projectd.data.models.Track
import com.google.gson.annotations.SerializedName
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton

interface TrackService {

    @GET("search?term=star&amp;country=au&amp;media=movie&amp;all")
    suspend fun getApiResult(): ApiResult

    @GET("lookup?id=1440812215")
    suspend fun getTestResult(): ApiResult

    @FormUrlEncoded
    @GET("lookup?id={id}")
    fun getFlowApiResult(@Path("id") id: Int): Track
}