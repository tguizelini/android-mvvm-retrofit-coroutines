package br.com.tguizelini.androidmvvmcoroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {
    private val service = CountryService()
    private val _items = MutableLiveData<List<Country>>()

    val items: LiveData<List<Country>>
        get() = _items

    fun fetchCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            val res = service.getCountries()

            if (res.isSuccessful) {
                withContext(Dispatchers.Main) {
                    _items.value = res.body()
                }
            }
        }
    }
}