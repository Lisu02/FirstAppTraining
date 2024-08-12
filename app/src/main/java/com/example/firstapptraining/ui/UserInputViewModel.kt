package com.example.firstapptraining.ui

import android.service.autofill.UserData
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.firstapptraining.data.UserDataUiEvents
import com.example.firstapptraining.data.UserInputScreenState

class UserInputViewModel : ViewModel() {

    companion object{
        const val TAG = "UserIntputViewModel"
    }

    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvents){
        when(event){
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
                Log.d(TAG,"onEvent:UserNameEntred->>")
                Log.d(TAG,"${uiState.value}")
            }
            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalValue
                )
                Log.d(TAG,"onEvent:AnimalSelected->>")
                Log.d(TAG,"${uiState.value}")
            }
        }
    }

    fun isValidState(): Boolean{
        if(!uiState.value.nameEntered.isNullOrEmpty()
            &&
            !uiState.value.animalSelected.isNullOrEmpty()){
            return true
        }else return false
    }
}


