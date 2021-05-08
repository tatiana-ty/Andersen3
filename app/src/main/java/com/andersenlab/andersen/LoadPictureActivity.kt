package com.andersenlab.andersen

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoadPictureActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var inputLayout: TextInputLayout
    private lateinit var inputEditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_picture)
        imageView = findViewById(R.id.image_view)
        inputLayout = findViewById(R.id.input_layout)
        inputEditText = findViewById(R.id.input_edit_text)
        inputLayout.setEndIconOnClickListener {
            if (inputEditText.text.toString() != "") {
                Glide.with(this).load(inputEditText.text.toString()).error(R.drawable.ic_load_error_vector).into(imageView)
            } else {
                imageView.setImageResource(R.drawable.ic_no_photo_vector)
            }
        }
    }
}