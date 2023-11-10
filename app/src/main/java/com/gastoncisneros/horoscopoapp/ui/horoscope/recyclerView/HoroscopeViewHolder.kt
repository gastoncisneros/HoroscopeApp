package com.gastoncisneros.horoscopoapp.ui.horoscope.recyclerView

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gastoncisneros.horoscopoapp.databinding.ItemHoroscopeBinding
import com.gastoncisneros.horoscopoapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo){
        val context = binding.tvHoroscope.context // Puedo sacar el contexto de la vista a la que binding tenga acceso
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscope.text = context.getString(horoscopeInfo.name) // Name es una referencia a la posicion de string en el archivo string.xml
    }
}