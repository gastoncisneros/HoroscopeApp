package com.gastoncisneros.horoscopoapp.ui.horoscope.recyclerView

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.gastoncisneros.horoscopoapp.databinding.ItemHoroscopeBinding
import com.gastoncisneros.horoscopoapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit){

        val context = binding.tvHoroscope.context // Puedo sacar el contexto de la vista a la que binding tenga acceso
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscope.text = context.getString(horoscopeInfo.name) // Name es una referencia a la posicion de string en el archivo string.xml

        binding.parent.setOnClickListener {
            startRotationAnimation(binding.ivHoroscope, newLambda = {onItemSelected(horoscopeInfo)})
        }
    }

    private fun startRotationAnimation(view: View, newLambda:() -> Unit){
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction(newLambda)
            start()
        }
    }
}