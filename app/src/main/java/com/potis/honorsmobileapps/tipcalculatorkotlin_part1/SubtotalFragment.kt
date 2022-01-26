package com.potis.honorsmobileapps.tipcalculatorkotlin_part1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.potis.honorsmobileapps.tipcalculatorkotlin_part1.databinding.FragmentMainBinding


class SubtotalFragment : Fragment() {
    private var _binding: FragmentMainBinding? =null
    private val binding get()= _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentMainBinding.inflate(inflater,container,false)
        val rootView =binding.root
        return rootView
    }
    override fun onDestroyView(){
        super.onDestroyView()
        _binding =null
    }
}