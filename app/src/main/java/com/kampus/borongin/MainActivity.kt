package com.kampus.borongin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var buttomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragment(HomeFragment())

        if (supportActionBar != null){
            supportActionBar!!.hide()
        }

//
//        binding.ivAccessItem.setOnClickListener {
//            val i = Intent(this,DetailProduk::class.java)
//            startActivity(i)
//        }

        buttomNav = findViewById(R.id.nav_main) as BottomNavigationView
        buttomNav.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home ->{
                    loadFragment(HomeFragment())
                    true
                }
                R.id.cart -> {
                    loadFragment(KeranjangFragment())
                    true
                }
                R.id.riwayat -> {
                    loadFragment(HistoryFragment())
                    true
                }
            }
            false
        }
    }

    private fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}