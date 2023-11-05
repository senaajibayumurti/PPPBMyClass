package com.example.pertemuan10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.pertemuan10.databinding.ActivityProfileBinding
import com.example.pertemuan10.MainActivity.Companion.STUDENT_NAME
import com.example.pertemuan10.MainActivity.Companion.STUDENT_GPA
import com.example.pertemuan10.MainActivity.Companion.STUDENT_MAJOR
import com.example.pertemuan10.MainActivity.Companion.STUDENT_PFP

class Profile : AppCompatActivity() {
    private lateinit var binding:ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            val gpa = intent.getDoubleExtra(STUDENT_GPA, 0.0)

            studentNameTxt.text = intent.getStringExtra(STUDENT_NAME)
            studentMajorTxt.text = intent.getStringExtra(STUDENT_MAJOR)
            studentGpaTxt.text = gpa.toString()
            pfp.setImageResource(intent.getIntExtra(STUDENT_PFP, 0))

            if (gpa >= 3.5){
                binding.banner.setBackgroundResource(R.color.green)
            } else if (gpa >= 3.0){
                binding.banner.setBackgroundResource(R.color.yellow)
            } else {
                binding.banner.setBackgroundResource(R.color.red)
            }
        }
    }
}