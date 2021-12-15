package com.example.xml_format


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.xml_format.databinding.RowRecyclerviewBinding


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    class RecyclerViewHolder(val binding: RowRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    lateinit var StudentList: List<Student>

    fun setStudentsList(studentsList: List<Student>) {
        this.StudentList = studentsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(RowRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        var currentStudent = StudentList[position]
        holder.binding.apply {
            stInfoTV.text = "id: ${currentStudent.id}\nstudent name: ${currentStudent.name}\nstudent grade: ${currentStudent.grade}"
        }
    }
    override fun getItemCount() = StudentList.size
}
