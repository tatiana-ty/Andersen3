package com.andersenlab.andersen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    
    private lateinit var fab: FloatingActionButton
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fab = findViewById(R.id.floating_action_button)
        fab.setOnClickListener{
            val intent = Intent(this@MainActivity, LoadPictureActivity::class.java)
            startActivity(intent)
        }
    }
}