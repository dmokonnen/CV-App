package edu.miu.curriculumvitaeapp

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.io.FileWriter
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var homeFragment: HomeFragment
    private lateinit var workFragment: WorkFragment
    private lateinit var contactFragment: ContactFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeFragment = HomeFragment()
        setCurrentFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.homeMenuItem -> {
                    homeFragment = HomeFragment()
                    setCurrentFragment(homeFragment)
                }

                R.id.contactMenuItem -> {
                    contactFragment = ContactFragment()
                    setCurrentFragment(contactFragment)
                }

                R.id.workMenuItem -> {
                    workFragment = WorkFragment()
                    setCurrentFragment(workFragment)
                }
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }

    fun addSkillClicked(view: View) {
        val input = EditText(this)
        AlertDialog.Builder(this)
            .setTitle("Add new skill")
            .setView(input)
            .setPositiveButton("Ok") { _, _ ->
                val newSkill = input.text.toString()
                homeFragment.skills.add(0, newSkill)
                val gson = Gson()
                val skills = Skills()
                skills.skills = homeFragment.skills
                val response = gson.toJson(skills)
                val path = (Environment.getExternalStorageDirectory().absolutePath + "/skills.json")
                try {
                    val writer = FileWriter(path)
                    writer.write(response)
                    writer.flush()
                } catch (e1: IOException) {
                    e1.printStackTrace()
                }
            }
            .setNegativeButton("Cancel") { _, _ ->
            }
            .show()
    }
}
