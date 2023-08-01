package com.rns.marsphotosapplication.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rns.marsphotosapplication.network.MarsApiStatus
import com.rns.marsphotosapplication.network.MarsPhotoItem
import com.rns.marsphotosapplication.network.MarsApi
import kotlinx.coroutines.launch
import java.lang.Exception

class MarsPhotosViewModel : ViewModel() {
    private var _status = MutableLiveData<MarsApiStatus>()
    val status: LiveData<MarsApiStatus> get() = _status

    private var _photos = MutableLiveData<List<MarsPhotoItem>>()
    val photos: LiveData<List<MarsPhotoItem>> get() = _photos

    init {
        getMarsPhoto()
    }

    private fun getMarsPhoto() {
        viewModelScope.launch {
            _status.value = MarsApiStatus.LOADING
            try {
                _photos.value = MarsApi.retrofitService.getPhotos()
                _status.value = MarsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = MarsApiStatus.ERROR
                _photos.value = listOf()
            }
        }
    }
}