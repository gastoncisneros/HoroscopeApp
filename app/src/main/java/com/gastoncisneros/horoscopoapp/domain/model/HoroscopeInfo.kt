package com.gastoncisneros.horoscopoapp.domain.model

import com.gastoncisneros.horoscopoapp.R

sealed class HoroscopeInfo(val img:Int, val name:Int){
    object  Aries: HoroscopeInfo(R.drawable.aries, R.string.Aries)
    object  Taurus: HoroscopeInfo(R.drawable.tauro, R.string.Taurus)
    object  Gemini: HoroscopeInfo(R.drawable.geminis, R.string.Gemini)
    object  Aquarius: HoroscopeInfo(R.drawable.aquario, R.string.Aquarius)
    object  Cancer: HoroscopeInfo(R.drawable.cancer, R.string.Cancer)
    object  Scorpio: HoroscopeInfo(R.drawable.escorpio, R.string.Scorpio)
    object  Capricorn: HoroscopeInfo(R.drawable.capricornio, R.string.Capricorn)
    object  Leo: HoroscopeInfo(R.drawable.leo, R.string.Leo)
    object  Virgo: HoroscopeInfo(R.drawable.virgo, R.string.Virgo)
    object  Libra: HoroscopeInfo(R.drawable.libra, R.string.Libra)
    object  Sagittarius: HoroscopeInfo(R.drawable.sagitario, R.string.Sagittarius)
    object  Pisces: HoroscopeInfo(R.drawable.piscis, R.string.Pisces)
}