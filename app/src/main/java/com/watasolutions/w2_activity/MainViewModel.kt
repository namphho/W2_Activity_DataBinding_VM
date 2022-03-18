package com.watasolutions.w2_activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ErrorValid {
    EMAIL_ERROR,
    EMAIL_PASSWORD
}


data class Resp(val isSuccess: Boolean, val errorValid: ErrorValid?)

class MainViewModel() : ViewModel() {
    private var _errorLiveData: MutableLiveData<String> = MutableLiveData()
    val errorLiveData: LiveData<String>
        get() = _errorLiveData

    private var _successLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val successLiveData: LiveData<Boolean>
        get() = _successLiveData


    fun checkEmailAndPasswordIsValid(email: String, password: String) {
        //kiểm tra email
        val isEmailValid = Validators.isEmailValid(email)
        //kiểm tra password
        val isPasswordValid = Validators.isPasswordInvalid(password)
        if (!isEmailValid) {
            _errorLiveData.postValue("email không hợp lệ")
            return
        }
        if (!isPasswordValid) {
            _errorLiveData.postValue("password không hợp lệ")
            return
        }
        return _successLiveData.postValue(true)
    }
}