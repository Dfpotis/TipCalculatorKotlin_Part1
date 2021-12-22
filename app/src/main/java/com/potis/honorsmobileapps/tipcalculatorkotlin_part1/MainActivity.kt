package com.potis.honorsmobileapps.tipcalculatorkotlin_part1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.potis.honorsmobileapps.tipcalculatorkotlin_part1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        val rootView= binding.root
        setContentView(rootView)
    }

}
