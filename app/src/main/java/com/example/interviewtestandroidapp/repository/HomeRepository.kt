package com.example.interviewtestandroidapp.repository

import com.example.interviewtestandroidapp.Network.AppServices
import com.example.interviewtestandroidapp.Network.Result
import com.example.interviewtestandroidapp.model.MedicineModel
import javax.inject.Inject

class HomeRepository @Inject constructor(private val appServices: AppServices) {
    suspend fun getData(): Result<MedicineModel?>{
        return appServices.getData()
    }
}