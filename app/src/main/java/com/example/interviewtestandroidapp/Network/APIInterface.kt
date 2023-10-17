package com.example.interviewtestandroidapp.Network

import android.provider.SyncStateContract
import com.example.interviewtestandroidapp.model.MedicineModel
import com.example.interviewtestandroidapp.util.Constant
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface APIInterface {

    @GET(Constant.dataUrl)
    suspend fun getMedicine(): Response<MedicineModel>

}