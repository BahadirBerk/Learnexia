package com.example.learnexia

import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class meyveDetayAktivite : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meyve_detay_aktivite)

        var fruit = intent.getStringExtra("fruit")!!.lowercase()
        var iid = resources.getIdentifier(fruit, "drawable",packageName)
        var iv = findViewById<ImageView>(R.id.imageView2)

        var mid = resources.getIdentifier(fruit, "raw", packageName)
        var mp = MediaPlayer.create(applicationContext, mid)
        mp.start()
        iv.setImageResource(iid)

    }
}