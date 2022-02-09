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
import retrofit2.http.*
import javax.inject.Singleton

interface TrackService {

    @GET("search?term=star&amp;country=au&amp;media=movie&amp;all")
    suspend fun getApiResult(): ApiResult

    @GET("lookup?id=")
    suspend fun getTestResult(@Query("id") id: Int): ApiResult

    /** TODO
     * Test how you can
     * fetch specific data
     * with flow state
     */
    @FormUrlEncoded
    @GET("lookup?id={id}")
    fun getFlowApiResult(@Path("id") id: Int): Flow<Track>
}