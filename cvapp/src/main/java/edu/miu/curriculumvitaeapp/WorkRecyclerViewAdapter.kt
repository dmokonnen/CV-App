package edu.miu.curriculumvitaeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorkRecyclerViewAdapter : RecyclerView.Adapter<WorkRecyclerViewAdapter.MyViewHolder>() {

    private val jobs = listOf(
        Job(
            "Software Engineer (iOS)",
            "DMI (Digital Management LLC) • Full-time",
            "Jun 2015 - Apr 2018 • 2 yrs 11 mos",
            "Phnom Penh, Cambodia",
            "iOS and watchOS App Developer"
        ),
        Job(
            "Associate Software Engineer (iOS)",
            "Golden Gekko (A DMI Company) • Internship",
            "Dec 2014 - May 2015 • 6 mos",
            "Phnom Penh, Cambodia",
            "iOS App Developer"
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.work_row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return jobs.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.populate(jobs[position])
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView = view.findViewById<ImageView>(R.id.imageView)
        private val jobTitleTextView = view.findViewById<TextView>(R.id.jobTitleTextView)
        private val companyNameTextView = view.findViewById<TextView>(R.id.companyNameTextView)
        private val workDurationTextView = view.findViewById<TextView>(R.id.workDurationTextView)
        private val companyLocationTextView =
            view.findViewById<TextView>(R.id.companyLocationTextView)
        private val mainResponsibilityTextView =
            view.findViewById<TextView>(R.id.mainResponsibilityTextView)

        fun populate(job: Job) {
            with(job) {
                jobTitleTextView.text = title
                companyNameTextView.text = companyName
                workDurationTextView.text = duration
                companyLocationTextView.text = location
                mainResponsibilityTextView.text = mainResponsibility
            }
        }
    }
}