package edu.miu.curriculumvitaeapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class HomeFragment : Fragment() {

    lateinit var listView: ListView
    val skills = arrayListOf("Coding")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        listView = view.findViewById(R.id.listView)
        listView.adapter = ArrayAdapter(context!!, R.layout.support_simple_spinner_dropdown_item, skills)
        return view
    }

}
