package com.example.interviewtestandroidapp.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class MedicineModel (
    val problems: ArrayList<Problem>? = null
)

data class Problem (
    @SerializedName("Diabetes")
    val diabetes: ArrayList<Diabetes>? = null,
    @SerializedName("Asthma")
    val asthma: ArrayList<Asthma>? = null
)

class Asthma()

data class Diabetes (
    val medications: ArrayList<Medication>? = null,
    val labs: ArrayList<Lab>? = null
)

data class Lab (
    val missingField: String? = null
)

data class Medication (
    val medicationsClasses: ArrayList<MedicationsClass>? = null
)

data class MedicationsClass (
    val className: ArrayList<ClassName>? = null,
    val className2: ArrayList<ClassName>? = null
)

data class ClassName (
    val associatedDrug: ArrayList<AssociatedDrug>? = null,
    @SerializedName("associatedDrug#2")
    val associatedDrug2: ArrayList<AssociatedDrug>? = null
)


@Entity(tableName = "AssociatedDrug")
data class AssociatedDrug (
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "name")
    val name: String? = null,
    @ColumnInfo(name = "dose")
    val dose: String? = null,
    @ColumnInfo(name = "strength")
    val strength: String? = null
)
