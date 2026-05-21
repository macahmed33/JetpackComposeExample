package com.example.interviewtestandroidapp.Network

import androidx.compose.runtime.snapshots.SnapshotApplyResult
import com.example.interviewtestandroidapp.model.MedicineModel
import com.example.interviewtestandroidapp.room.AssociatedDrugDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class AppServices @Inject constructor(private val apiInterface: APIInterface){

    suspend fun getData(): Result<MedicineModel?> {
        return withContext(Dispatchers.IO) {
            val data = apiInterface.getMedicine()
            if (data.isSuccessful){

               return@withContext Result.success(data.body())
            }else{
                return@withContext Result.error("error")
            }
        }
    }

    }

