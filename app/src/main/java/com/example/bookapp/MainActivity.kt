package com.example.bookrapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bookapp.DetailActivity
import com.example.bookapp.R

class MainActivity : AppCompatActivity() {

    companion object {
        val titles = ArrayList<String>()
        val authors = ArrayList<String>()
        val ratings = ArrayList<Int>()
        val comments = ArrayList<String>()
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val title = findViewById<EditText>(R.id.txtTitle)
        val author = findViewById<EditText>(R.id.txtAuthor)
        val rating = findViewById<EditText>(R.id.txtRating)
        val comment = findViewById<EditText>(R.id.txtComment)

        findViewById<Button>(R.id.btnAdd).setOnClickListener {

            if (title.text.isEmpty() || author.text.isEmpty() || rating.text.isEmpty()) {
                Toast.makeText(this,"Fill all fields",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            titles.add(title.text.toString())
            authors.add(author.text.toString())
            ratings.add(rating.text.toString().toInt())
            comments.add(comment.text.toString())

            Toast.makeText(this,"Book Added",Toast.LENGTH_SHORT).show()

            title.text.clear()
            author.text.clear()
            rating.text.clear()
            comment.text.clear()
        }

        findViewById<Button>(R.id.btnView).setOnClickListener {
            startActivity(Intent(this, DetailActivity::class.java))
        }

        findViewById<Button>(R.id.btnExit).setOnClickListener {
            finish()
        }
    }
}
