package com.potis.honorsmobileapps.tipcalculatorkotlin_part1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.potis.honorsmobileapps.tipcalculatorkotlin_part1.databinding.FragmentMainBinding
import com.potis.honorsmobileapps.tipcalculatorkotlin_part1.databinding.FragmentSubtotalBinding


class SubtotalFragment : Fragment() {
    private var _binding: FragmentSubtotalBinding? =null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSubtotalBinding.inflate(inflater,container,false)

        val rootView =binding.root
        binding.butt.setOnClickListener{
            rootView.findNavController().navigateUp()
        }
        return rootView
    }
    override fun onDestroyView(){
        super.onDestroyView()
        _binding =null
    }
}