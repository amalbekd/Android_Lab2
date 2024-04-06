package com.example.lab_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab_2.adapter.DragonAdapter
import com.example.lab_2.databinding.ActivityMainBinding
import com.example.lab_2.fragment.DragonListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, DragonListFragment())
            .commit()
    }



}