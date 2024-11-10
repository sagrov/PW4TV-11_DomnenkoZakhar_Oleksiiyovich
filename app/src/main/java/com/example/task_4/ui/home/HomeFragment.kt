package com.example.task_4.ui.home

import android.os.Bundle
import kotlin.math.*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.task_4.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.buttonCalculateTask1.setOnClickListener { Task_1() }

        return root
    }

    private fun Task_1()
    {
        val U = 10.0
        val Sm = binding.Sm.text.toString().toDouble()
        val jEk = binding.jEk.text.toString().toDouble()
        val I = binding.I.text.toString().toDouble()
        val t = binding.t.text.toString().toDouble()
        val Im = Sm / 2 / (sqrt(3.0) * U)
        val ImPA = 2 * Im
        val sEk = Im / jEk
        val s = I * 1000 * sqrt(t) / 92

        var output = "Розрахунковий струм для нормального режиму: ${round(Im)} A\n" +
                "Розрахунковий струм для післяаварійного режиму: ${round(ImPA)} A\n" +
                "Економічний переріз: ${round(sEk)} мм^2\n" +
                "Оптимальний переріз: ${round(s)} мм^2\n"
        binding.outputTask1.text = output;
    }

    private fun round(num: Double) = "%.2f".format(num)
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}