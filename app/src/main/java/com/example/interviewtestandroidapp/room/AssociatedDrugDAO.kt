package com.example.interviewtestandroidapp.room

import androidx.room.*
import com.example.interviewtestandroidapp.model.AssociatedDrug

@Dao
interface AssociatedDrugDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAssociatedDrugs(list: ArrayList<AssociatedDrug>)

    @Query("SELECT * FROM AssociatedDrug")
    fun getAllAssociateDrug(): List<AssociatedDrug>

    @Update
    suspend fun updateAssociateDrug(associatedDrug: AssociatedDrug)

    @Delete
    suspend fun deleteAssociateDrug(associatedDrug: AssociatedDrug)

    @Query("DELETE FROM AssociatedDrug")
    fun deleteAssociatedDrugData()

}