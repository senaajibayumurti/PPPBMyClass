package com.example.pertemuan10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pertemuan10.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val STUDENT_NAME = "student_name"
        const val STUDENT_GPA = "student_gpa"
        const val STUDENT_MAJOR = "student_major"
        const val STUDENT_PFP = "student_pfp"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterMyClass = MyClassAdapter(generateMyClass()) {
            myclass -> Toast.makeText(this@MainActivity, "Student Name: ${myclass.name}", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, Profile::class.java)
            intent.putExtra(STUDENT_NAME, myclass.name)
            intent.putExtra(STUDENT_GPA, myclass.gpa)
            intent.putExtra(STUDENT_MAJOR, myclass.major)
            intent.putExtra(STUDENT_PFP, myclass.pic)
            startActivity(intent)
        }
        with(binding){
            rvStudent.apply {
                adapter = adapterMyClass
//                layoutManager = GridLayoutManager(this@MainActivity, 2)
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateMyClass() : List<MyClass>{
        return listOf(
            MyClass(
                name = "Bahari", gpa = randomGpa(), major = "Ecology",
                pic = R.drawable.bahari),
            MyClass(
                name = "Chichae", gpa = randomGpa(), major = "Manager",
                pic = R.drawable.chichae),
            MyClass(
                name = "Fiorayne", gpa = randomGpa(), major = "Hunting",
                pic = R.drawable.fiorayne),
            MyClass(
                name = "Hinoa", gpa = randomGpa(), major = "Manager",
                pic = R.drawable.hinoa),
            MyClass(
                name = "Luchika", gpa = randomGpa(), major = "Ecology",
                pic = R.drawable.luchika),
            MyClass(
                name = "Minoto", gpa = randomGpa(), major = "Manager",
                pic = R.drawable.minoto),
            MyClass(
                name = "Tadori", gpa = randomGpa(), major = "Ecology",
                pic = R.drawable.tadori),
            MyClass(
                name = "Utsushi", gpa = randomGpa(), major = "Hunting",
                pic = R.drawable.utsushi),
            MyClass(
                name = "Yomogi", gpa = randomGpa(), major = "Cooking",
                pic = R.drawable.yomogi)
        )
    }
    fun randomGpa(): Double {
        val randumNum = 1.0 + Random.nextDouble() * (4.0 - 1.0)
        val gpa = Math.round(randumNum * 10.0) / 10.0
        return gpa
    }

}