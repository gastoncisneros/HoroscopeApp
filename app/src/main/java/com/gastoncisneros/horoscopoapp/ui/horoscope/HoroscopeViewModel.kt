package com.gastoncisneros.horoscopoapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.gastoncisneros.horoscopoapp.data.providers.HoroscopeProvider
import com.gastoncisneros.horoscopoapp.domain.model.HoroscopeInfo
import com.gastoncisneros.horoscopoapp.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider): ViewModel() {

    private var _horoscopeInfo = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscopeFlow:StateFlow<List<HoroscopeInfo>> = _horoscopeInfo // Los flows no son mutables, pero pueden acceder a datos que si.

    init {
        _horoscopeInfo.value = horoscopeProvider.getHoroscopes()
    }
}