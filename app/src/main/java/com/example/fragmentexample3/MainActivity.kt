package com.example.fragmentexample3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentexample3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NewFragment.DatoDevuelto {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChangeFragment.setOnClickListener {
            showFragment()
        }
    }

    private fun showFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = NewFragment()

        transaction.replace(R.id.fragment_holder, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun datoActualizado(dato: String) {
        binding.tvInformation.text = dato
    }
}