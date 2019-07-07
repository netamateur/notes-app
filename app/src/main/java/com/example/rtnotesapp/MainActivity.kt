package com.example.rtnotesapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        var imageIdList = arrayOf(
            R.drawable.sunflower,
            R.drawable.vg_sunflowers,
            R.drawable.kusama_pumpkins
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val fragment = CardFragment()
        val fragment2 = CardFragment()
        val fragment3 = CardFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.position1, fragment)
        ft.add(R.id.position2, fragment2)
        ft.add(R.id.position3, fragment3)
        ft.commit()

        fab.setOnClickListener {
            val intent = Intent(this, NavigationActivity::class.java)
            startActivity(intent)
        }

//        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_tab_menu)
//
//        bottomNav.setOnNavigationItemSelectedListener { item ->
//            when(item.itemId) {
//                R.id.action_list -> { true }
//                R.id.action_collection -> { true }
//                R.id.action_map -> { true }
//                else -> false
//            }
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
