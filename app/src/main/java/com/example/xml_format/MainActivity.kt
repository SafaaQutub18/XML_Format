package com.example.xml_format

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xml_format.databinding.ActivityMainBinding
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val myAdapter : RecyclerViewAdapter by lazy { RecyclerViewAdapter() }
    private lateinit var studentList : List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Adapter setting
        binding.recyclerV.adapter = myAdapter
        binding.recyclerV.layoutManager = LinearLayoutManager(this)

        try{
            val parser = XmlParserHandler()
            val iStream = assets.open("Students.xml")
            studentList = parser.parse(iStream)
            myAdapter.setStudentsList(studentList)

        }catch (e: IOException) {
            println("ISSUE: $e")
        }


    }
}