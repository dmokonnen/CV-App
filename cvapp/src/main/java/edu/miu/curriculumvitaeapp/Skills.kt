package edu.miu.curriculumvitaeapp

import com.google.gson.annotations.SerializedName

class Skills {
    @SerializedName("skills")
    lateinit var skills: ArrayList<String>
}