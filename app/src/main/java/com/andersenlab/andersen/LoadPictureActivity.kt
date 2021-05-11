package com.andersenlab.andersen

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
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
                Glide
                        .with(this)
                        .load(inputEditText.text.toString())
                        .listener(
                            object : RequestListener<Drawable> {
                                override fun onLoadFailed(p0: GlideException?, p1: Any?, target: Target<Drawable>?, p3: Boolean): Boolean {
                                    Toast.makeText(applicationContext, p0.toString(), Toast.LENGTH_SHORT).show()
                                    return true
                                }
                                override fun onResourceReady(p0: Drawable?, p1: Any?, target: Target<Drawable>?, p3: DataSource?, p4: Boolean): Boolean {
                                    return false
                                }
                            }
                        )
                        .error(R.drawable.ic_load_error_vector)
                        .into(imageView)
            } else {
                imageView.setImageResource(R.drawable.ic_no_photo_vector)
            }
        }
    }
}