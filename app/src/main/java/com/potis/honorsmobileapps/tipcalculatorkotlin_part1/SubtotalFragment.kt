package com.potis.honorsmobileapps.tipcalculatorkotlin_part1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.potis.honorsmobileapps.tipcalculatorkotlin_part1.databinding.FragmentSubtotalBinding


class SubtotalFragment : Fragment() {
    private var _binding: FragmentSubtotalBinding? =null
    private val binding get()= _binding!!
    var num=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSubtotalBinding.inflate(inflater,container,false)

        val rootView =binding.root
        binding.butt.setOnClickListener{

            val action=SubtotalFragmentDirections.actionSubtotalFragmentToMainFragment(num)
            rootView.findNavController().navigate(action)
        }
        binding.one.setOnClickListener{
            num+="1"
            binding.subtotal.text="$$num.00"
        }
        binding.two.setOnClickListener{
            num+="2"
            binding.subtotal.text="$$num.00"
        }
        binding.three.setOnClickListener{
            num+="3"
            binding.subtotal.text="$$num.00"
        }
        binding.four.setOnClickListener{
            num+="4"
            binding.subtotal.text="$$num.00"
        }
        binding.five.setOnClickListener{
            num+="5"
            binding.subtotal.text="$$num.00"
        }
        binding.six.setOnClickListener{
            num+="6"
            binding.subtotal.text="$$num.00"
        }
        binding.seven.setOnClickListener{
            num+="7"
            binding.subtotal.text="$$num.00"
        }
        binding.eight.setOnClickListener{
            num+="8"
            binding.subtotal.text="$$num.00"
        }
        binding.nine.setOnClickListener{
            num+="9"
            binding.subtotal.text="$$num.00"
        }
        binding.zero.setOnClickListener{
            num+="0"
            binding.subtotal.text="$$num.00"
        }
        binding.back.setOnClickListener{
            if(num.length>0){
            var number=num.toInt()
            number/=10
            num=number.toString()
            if(num.equals("0"))
                num=""
            binding.subtotal.text="$$number.00"}
        }
        return rootView
    }
    override fun onDestroyView(){
        super.onDestroyView()
        _binding =null
    }
}