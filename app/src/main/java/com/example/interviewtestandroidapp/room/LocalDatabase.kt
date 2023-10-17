package com.example.interviewtestandroidapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.interviewtestandroidapp.model.AssociatedDrug

@Database(
    //entities = [AppSelectedModel::class, ShortcutSelectedApps::class, DontAllowAppSelectedModel::class, DeviceAppModel::class],
    entities = [AssociatedDrug::class],
    exportSchema = false,
    version = 1
)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun getAssociatedDrugDao(): AssociatedDrugDAO

}