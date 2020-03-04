package edu.miu.curriculumvitaeapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactRecyclerViewAdapter : RecyclerView.Adapter<ContactRecyclerViewAdapter.MyViewHolder>() {

    private val contacts = listOf(
        Contact("LinkedIn", "https://www.linkedin.com/your-profile", R.drawable.ic_contact_email),
        Contact("GitHub", "https://www.github.com/your-profile", R.drawable.ic_contact_email),
        Contact("Phone", "(267) 918-7095", R.drawable.ic_contact_phone),
        Contact("Email", "kanharithsok@gmail.com", R.drawable.ic_contact_email),
        Contact("IM", "live:kanharith.sok (Skype)", R.drawable.ic_contact_email)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.contact_row, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.populate(contacts[position], hideSeparator = (position == contacts.size - 1))
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val thumbnailImageView = view.findViewById<ImageView>(R.id.thumbnailImageView)
        private val titleTextView = view.findViewById<TextView>(R.id.titleTextView)
        private val urlTextView = view.findViewById<TextView>(R.id.urlTextView)
        private val separatorView = view.findViewById<View>(R.id.separatorView)

        fun populate(contact: Contact, hideSeparator: Boolean = false) {
            thumbnailImageView.setImageResource(contact.icon)
            titleTextView.text = contact.title
            urlTextView.text = contact.value
            var separatorColor = if (hideSeparator) Color.TRANSPARENT else Color.LTGRAY
            separatorView.setBackgroundColor(separatorColor)
        }
    }
}