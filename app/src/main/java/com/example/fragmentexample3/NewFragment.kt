package com.example.fragmentexample3

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentexample3.databinding.NewFragmentBinding
import java.lang.RuntimeException

class NewFragment: Fragment() {

    private lateinit var binding: NewFragmentBinding
    private val TAG = "FragmentNew"
    private var datoFragment: DatoDevuelto? = null

    interface DatoDevuelto {
        fun datoActualizado(dato: String)
    }

    override fun onAttach(context: Context) {
        Log.d(TAG, "onAttach")
        super.onAttach(context)

        if (context is DatoDevuelto) {
            datoFragment = context
        } else {
            throw RuntimeException(requireContext().toString() + " debe implementar DatoDevuelto")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        binding = NewFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
        binding.btnSend.setOnClickListener {
            actualizarDato()
        }
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach")
        datoFragment = null
    }

    // Metodo encargado de pasar la informacion a la activity contenedora
    private fun actualizarDato() {
        if (!binding.etInput.text.isEmpty()) {
            datoFragment?.datoActualizado(binding.etInput.text.toString())
        } else {
            datoFragment?.datoActualizado("Sin informacion")
        }
    }
}