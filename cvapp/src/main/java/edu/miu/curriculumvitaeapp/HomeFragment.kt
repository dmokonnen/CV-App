package edu.miu.curriculumvitaeapp

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.gson.Gson
import java.io.FileNotFoundException
import java.io.FileReader

class HomeFragment : Fragment() {

    lateinit var listView: ListView
    var skills = arrayListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        listView = view.findViewById(R.id.listView)
        listView.adapter =
            ArrayAdapter(context!!, R.layout.support_simple_spinner_dropdown_item, skills)
        val path = (Environment.getExternalStorageDirectory().absolutePath + "/skills.json")
        try {
            val reader = FileReader(path)
            val gson = Gson()
            val s = gson.fromJson(reader, Skills::class.java)
            skills.addAll(s.skills)
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
        return view
    }

}
