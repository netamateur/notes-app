package com.ritatse.notesapp

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem

class NavigationActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        //TODO shuffle images set
        fab.setOnClickListener { view ->
            imageIdList.getRandomSet()
            //loadImageSet

        }
    }

    private fun Array<Int>.getRandomSet(): ArrayList<Int> {
        val newSet = ArrayList<Int>()

        var x = 0
        while (x < 3) {
            val randomNum = (0 until this.size - 1).random()
            newSet.add(randomNum)
        }
        return newSet
    }


    override fun onStart() {
        super.onStart()

        val fragment = FlipbookFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.root, fragment)
        ft.commit()
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    //TODO change options menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.navigation, menu)
//        menuInflater.inflate(R.menu.menu_main, menu)
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


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            //TODO change icons

            R.id.nav_home -> {
                //TODO Link to Flipbook Fragment (initial fragment)

            }
            R.id.nav_gallery -> {
                //TODO Link to List Fragment
                //TODO not working - attach fragment to activity?
                val listFragment = ListFragment()
                val ft = supportFragmentManager.beginTransaction()
                ft.add(R.id.rootList, listFragment)
                ft.commit()

                //ft.replace?
                //shared fragement manager??
            }

            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {
                val intent = Intent(this, NoteItemActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    companion object {
        var imageIdList = arrayOf(
            R.drawable.sunflower,
            R.drawable.vg_sunflowers,
            R.drawable.kusama_pumpkins
        )
    }
}

//TODO start new activity from FAB
//val intent = Intent(this, NavigationActivity::class.java)
//startActivity(intent)