package com.example.drawernav.Models

import java.util.Date

data class Appointment(
    val id: Int,
    val type: String,
    val date: Date,
    val petName: String,
    val vetName: String,
    val status: String
)
