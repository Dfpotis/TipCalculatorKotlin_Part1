package com.potis.honorsmobileapps.tipcalculatorkotlin_part1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.potis.honorsmobileapps.tipcalculatorkotlin_part1.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding:FragmentMainBinding? =null
    private val binding get()= _binding!!
    var tip:Double=0.0
    var subtotal:Int=0
    var numGuest=0
    var finalTotal=0.0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentMainBinding.inflate(inflater,container,false)
        val rootView =binding.root
        setUpRadioButtons()
        setUpNumOfGuest()
        setUpTipSeek()
        val args=MainFragmentArgs.fromBundle(requireArguments())
        subtotal=(args.subs).toInt()
        binding.number.text="$"+args.subs+".00"
        return rootView
    }
    override fun onDestroyView(){
        super.onDestroyView()
        _binding =null
    }
    fun setUpRadioButtons(){
        binding.rad1.setOnClickListener{tip=.10
            binding.seek.progress=10
            setTotal()}
        binding.rad2.setOnClickListener{tip=.15
            binding.seek.progress=15
            setTotal()}
        binding.rad3.setOnClickListener{tip=.18
            binding.seek.progress=18
            setTotal()}
        binding.rad4.setOnClickListener{tip=.25
            binding.seek.progress=25
            setTotal()}

    }
    fun setRadioCheck(num:Int){
        if(num==10)
            binding.group.check(R.id.rad1)
        else if(num==15)
            binding.group.check(R.id.rad2)
        else if(num==18)
            binding.group.check(R.id.rad3)
        else if(num==25)
            binding.group.check(R.id.rad4)
        else
            binding.group.clearCheck()

    }
    fun setUpNumOfGuest(){
        val saa= ArrayAdapter.createFromResource(requireActivity(), R.array.guest,android.R.layout.simple_spinner_item)
        binding.spin.adapter=saa
        saa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spin.onItemSelectedListener= object: AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                numGuest=position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

    }
    fun setUpTipSeek(){
        binding.seek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            var progress=0
            override fun onProgressChanged(seekBar: SeekBar, progressNew: Int, fromUser: Boolean) {
                progress=progressNew
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                setRadioCheck(progress)
                val prog=progress.toDouble()
                tip=prog/100
                setTotal()
            }
        })
    }
    fun setTotal(){
        finalTotal=((subtotal).toDouble()*tip)+subtotal.toDouble()
        "$%.2f".format(finalTotal)
        binding.totalText.text=" $$finalTotal"
        binding.tipText.text=" "+((tip*100).toInt()).toString()+"%"
    }
}