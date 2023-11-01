package com.example.pertemuan10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.pertemuan10.databinding.ActivityMainBinding
import com.example.pertemuan10.databinding.ItemRestaurantBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterRestaurant = RestaurantAdapter(generateRestaurant()) {
            restaurant -> Toast.makeText(this@MainActivity, "Anda Memencet ${restaurant.name}, resto dari ${restaurant.type}.",
        Toast.LENGTH_SHORT).show()
        }
        with(binding){
            rvRestaurant.apply {
                adapter = adapterRestaurant
//                layoutManager = GridLayoutManager(this@MainActivity, 2)
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    fun generateRestaurant() : List<Restaurant>{
        return listOf(
            Restaurant(name = "Mbok Berek", type = "Yogya"),
            Restaurant(name = "Sindoro Sumbing", type = "Wonosobo"),
            Restaurant(name = "McDonalds", type = "Mamarika"),
            Restaurant(name = "Rukira Nashimura", type = "Nipon"),
            Restaurant(name = "Holand Bakery", type = "Londo"),
            Restaurant(name = "Angkringan", type = "Java"),
            Restaurant(name = "Olive", type = "Yogya"),
            Restaurant(name = "Popeye", type = "Yogya Juga"),
            Restaurant(name = "Bu Rem", type = "Yogya Juga")
        )
    }
}