package com.example.lab_2.model

data class Animal(
    val name: String? = null,
    val taxonomy: Taxonomy,
    val location: ArrayList<String>? = null,
)
