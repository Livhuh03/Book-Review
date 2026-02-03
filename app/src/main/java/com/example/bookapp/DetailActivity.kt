package com.example.bookapp
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bookrapp.MainActivity

class DetailActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val output = findViewById<TextView>(R.id.txtOutput)

        findViewById<Button>(R.id.btnShow).setOnClickListener {

            var result = ""

            for (i in MainActivity.titles.indices) {

                result += "Title: ${MainActivity.titles[i]}\n"
                result += "Author: ${MainActivity.authors[i]}\n"
                result += "Rating: ${MainActivity.ratings[i]}\n"
                result += "Comment: ${MainActivity.comments[i]}\n\n"
            }

            output.text = result
        }

        findViewById<Button>(R.id.btnAverage).setOnClickListener {

            var total = 0

            for (r in MainActivity.ratings) {
                total += r
            }

            val avg = total.toDouble() / MainActivity.ratings.size

            Toast.makeText(this,"Average Rating: $avg",Toast.LENGTH_LONG).show()
        }

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}
