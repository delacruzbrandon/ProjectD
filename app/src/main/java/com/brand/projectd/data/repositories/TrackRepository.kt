package com.brand.projectd.data.repositories

import com.brand.projectd.data.models.ApiResult
import com.brand.projectd.data.service.TrackService
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@ViewModelScoped
class TrackRepository @Inject constructor(private val trackService: TrackService) {

    suspend fun getApiResult(): ApiResult =
        withContext(Dispatchers.IO) {
            trackService.getApiResult()
        }
}