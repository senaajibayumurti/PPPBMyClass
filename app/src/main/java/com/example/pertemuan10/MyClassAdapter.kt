package com.example.pertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pertemuan10.databinding.StudentMyclassBinding

typealias onClickStudent = (MyClass) -> Unit

class MyClassAdapter(private val listMyClass: List<MyClass>,
                     private val onClickStudent: onClickStudent) :
    RecyclerView.Adapter<MyClassAdapter.ItemRestaurantViewHolder>() {

    inner class ItemRestaurantViewHolder(private val
//                                       refer ke student_myclass.xml
                                         binding: StudentMyclassBinding):
            RecyclerView.ViewHolder(binding.root){

                fun bind(data : MyClass){
                    with(binding){
                        studentNameTxt.text = data.name
                        studentGpaTxt.text = data.gpa.toString()
                        studentMajorTxt.text = data.major
                        pfp.setImageResource(data.pic)

                        itemView.setOnClickListener {
                            onClickStudent(data)
                        }

                        if (data.gpa >= 3.5){
                            binding.studentGpaTxt.setBackgroundResource(R.color.green)
                        } else if (data.gpa >= 3.0){
                            binding.studentGpaTxt.setBackgroundResource(R.color.yellow)
                            binding.studentGpaTxt.setTextColor(ContextCompat.getColor(binding.root.context, R.color.black_1))
                        } else {
                            binding.studentGpaTxt.setBackgroundResource(R.color.red)
                        }
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemRestaurantViewHolder {
        val binding = StudentMyclassBinding.inflate(LayoutInflater.from(parent.context),
        parent, false)
        return ItemRestaurantViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listMyClass.size
    }

    override fun onBindViewHolder(holder: ItemRestaurantViewHolder, position: Int) {
        holder.bind(listMyClass[position])
    }
}