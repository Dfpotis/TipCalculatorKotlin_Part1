package com.potis.honorsmobileapps.tipcalculatorkotlin_part1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    var tip:Double=0.0
    lateinit var tipSeekBar: SeekBar
    var subtotal=100
    var numGuest=0
    var finalTotal=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRadioButtons()
        setUpNumOfGuest()
        setUpTipSeek()

    }
    fun setUpRadioButtons(){
        val rad1=findViewById<RadioButton>(R.id.rad1)
        val rad2=findViewById<RadioButton>(R.id.rad2)
        val rad3=findViewById<RadioButton>(R.id.rad3)
        val rad4=findViewById<RadioButton>(R.id.rad4)
        rad1.setOnClickListener{tip=.10
            tipSeekBar.progress=10
            setTotal()}
        rad2.setOnClickListener{tip=.15
            tipSeekBar.progress=15
            setTotal()}
        rad3.setOnClickListener{tip=.18
            tipSeekBar.progress=18
            setTotal()}
        rad4.setOnClickListener{tip=.25
            tipSeekBar.progress=25
            setTotal()}

    }
    fun setRadioCheck(num:Int){
        val group=findViewById<RadioGroup>(R.id.group)
        if(num==10)
            group.check(R.id.rad1)
        else if(num==15)
            group.check(R.id.rad2)
        else if(num==18)
            group.check(R.id.rad3)
        else if(num==25)
            group.check(R.id.rad4)
        else
        group.clearCheck()

    }
    fun setUpNumOfGuest(){
        val spin: Spinner=findViewById(R.id.spin)
        val saa=ArrayAdapter.createFromResource(this, R.array.guest,android.R.layout.simple_spinner_item)
        spin.adapter=saa
        saa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin.onItemSelectedListener= object: AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                numGuest=position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

    }
    fun setUpTipSeek(){
        tipSeekBar=findViewById(R.id.seek)
        tipSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
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
        val tipText=findViewById<TextView>(R.id.tipText)
        val totalText=findViewById<TextView>(R.id.totalText)
        finalTotal=((subtotal.toDouble())*tip).toInt()+subtotal
        totalText.text=" $$finalTotal"
        tipText.text=" "+(((subtotal.toDouble())*tip).toInt()).toString()+"%"
    }
}