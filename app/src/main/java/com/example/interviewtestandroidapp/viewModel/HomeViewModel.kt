package com.example.interviewtestandroidapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewtestandroidapp.Network.Result
import com.example.interviewtestandroidapp.model.AssociatedDrug
import com.example.interviewtestandroidapp.model.MedicineModel
import com.example.interviewtestandroidapp.repository.HomeRepository
import com.example.interviewtestandroidapp.room.AssociatedDrugDAO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    val homeRepository : HomeRepository,
    val associatedDrugDAO: AssociatedDrugDAO
    ): AndroidViewModel(application) {


    private val _associatedDrug = MutableStateFlow(ArrayList<AssociatedDrug>())
    val associatedDrug: StateFlow<ArrayList<AssociatedDrug>> get() = _associatedDrug
    private val _errorMsg= MutableStateFlow("error")
    val errorMsg: StateFlow<String> get() = _errorMsg
    private val _apiState = MutableStateFlow(Result.Status.LOADING)
    val apiState: StateFlow<Result.Status> get() = _apiState

    init {

        val list : ArrayList<AssociatedDrug> = ArrayList()
        list.addAll(associatedDrugDAO.getAllAssociateDrug())
        if (list.isNotEmpty()){
            _apiState.value = Result.Status.SUCCESS
            _associatedDrug.value= list
        }
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            try {
                if (_associatedDrug.value.isEmpty()) {
                    _apiState.value = Result.Status.LOADING
                }
                val data = homeRepository.getData()
                val finalList : ArrayList<AssociatedDrug> = ArrayList()
                when (data.status){
                    Result.Status.SUCCESS -> {
                        val medication = data?.data?.problems?.get(0)?.diabetes?.get(0)?.medications ?: ArrayList() //?.get(0)?.medicationsClasses?.get(0)?.className?.get(0)?.associatedDrug ?: ArrayList()
                        for (data in medication){
                            for (medicationClasses in data.medicationsClasses ?: ArrayList()){
                                for (class1 in medicationClasses.className ?: ArrayList()){
                                    finalList.addAll(class1.associatedDrug ?:ArrayList())
                                    finalList.addAll(class1.associatedDrug2 ?:ArrayList())
                                }
                                for (class2 in medicationClasses.className2 ?: ArrayList()){
                                    finalList.addAll(class2.associatedDrug ?:ArrayList())
                                    finalList.addAll(class2.associatedDrug2 ?:ArrayList())
                                }
                            }

                        }
                        _apiState.value = Result.Status.SUCCESS
                        _associatedDrug.value = finalList
                        associatedDrugDAO.deleteAssociatedDrugData()
                        associatedDrugDAO.insertAssociatedDrugs(finalList)

                    }
                    Result.Status.ERROR-> {
                        _apiState.value = Result.Status.ERROR
                        _errorMsg.value = data.errorMsg ?: "Un-known error"
                    }else -> {
                    _apiState.value = Result.Status.ERROR
                    _errorMsg.value = data.errorMsg ?: "Un-known error"
                    }
                }

            } catch ( e : Exception) {

                _apiState.value = Result.Status.ERROR
                _errorMsg.value = e.localizedMessage ?: "Un-known error"
            }
        }
    }

}