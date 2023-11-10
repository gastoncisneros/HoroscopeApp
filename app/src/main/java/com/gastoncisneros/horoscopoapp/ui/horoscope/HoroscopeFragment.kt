package com.gastoncisneros.horoscopoapp.ui.horoscope

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gastoncisneros.horoscopoapp.R
import com.gastoncisneros.horoscopoapp.databinding.FragmentHoroscopeBinding
import com.gastoncisneros.horoscopoapp.ui.horoscope.recyclerView.HoroscopeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeFragment : Fragment() {

    // by is a delegate
    private val horoscopeViewModel by viewModels<HoroscopeViewModel>()

    private lateinit var horoscopeAdapter: HoroscopeAdapter
    private var _binding: FragmentHoroscopeBinding? = null
    private val binding get() = _binding!! // !! es no sera nulo


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initRecyclerView()
        initUIState()
    }

    private fun initRecyclerView() {
        horoscopeAdapter = HoroscopeAdapter(onItemSelected = {
            // Este codigo dispara cuando se clickea un elemento en pantalla.
            // Esa seleccion se asigna en el ViewHolder, para ese momento ya tenemos HoroscopeInfo
            // EN la variable it.
            Toast.makeText(context, getString(it.name), Toast.LENGTH_LONG).show()
        })

        binding.rvHoroscope.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = horoscopeAdapter
        }
    }

    private fun initUIState() { // Attach to the horoscope view model and consume the flow
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                horoscopeViewModel.horoscopeFlow.collect{
                    // Cuando entre aca es porque hubo cambios en HoroscopeViewModel
                    horoscopeAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView( // Crea la vista del Fragment
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHoroscopeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}