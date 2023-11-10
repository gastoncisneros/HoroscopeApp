package com.gastoncisneros.horoscopoapp.data.providers

import com.gastoncisneros.horoscopoapp.domain.model.HoroscopeInfo
import com.gastoncisneros.horoscopoapp.domain.model.HoroscopeInfo.*
import javax.inject.Inject

// Makes the class injectable
class HoroscopeProvider @Inject constructor () {
    fun getHoroscopes():List<HoroscopeInfo>{
        return listOf(
            Aries,
            Taurus,
            Gemini,
            Aquarius,
            Cancer,
            Scorpio,
            Capricorn,
            Leo,
            Virgo,
            Libra,
            Sagittarius,
            Pisces
        )
    }
}