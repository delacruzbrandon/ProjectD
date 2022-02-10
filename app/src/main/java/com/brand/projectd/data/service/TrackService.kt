package com.brand.projectd.data.service

import com.brand.projectd.data.models.ApiResult
import com.brand.projectd.data.models.Track
import kotlinx.coroutines.flow.Flow
import retrofit2.http.*

interface TrackService {

    @GET("search?term=star&amp;country=au&amp;media=movie&amp;all")
    suspend fun getResultList(): ApiResult

    @GET("lookup?id=")
    suspend fun getResultSelected(@Query("id") id: Int): ApiResult

    /** TODO
     * Test how you can
     * fetch specific data
     * with flow state
     */
    @GET("lookup?id={id}")
    fun getFlowApiResult(@Path("id") id: Int): Flow<Track>
}