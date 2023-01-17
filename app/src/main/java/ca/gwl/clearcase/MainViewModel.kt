package ca.gwl.clearcase

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chuckerteam.chucker.api.ChuckerInterceptor
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class MainViewModel : ViewModel() {
    val updateText = MutableLiveData<String>()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.86.32:40074/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val myAPI = retrofit.create(MyAPI::class.java)

    fun makeRequest() {
        viewModelScope.launch {
            try {
                val response = myAPI.makeRequest()
                if (response.isSuccessful) {
                    updateText.value = "Success"
                } else {
                    updateText.value = "Failure"
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                updateText.value = "Failure"
            }
        }

    }

}