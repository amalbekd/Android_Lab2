package com.example.lab_2.network


import com.example.lab_2.model.Dragon
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import retrofit2.Call

interface DragonService {

    @Headers("X-Api-Key: wLrnkZ+qy6LvNHDs/NGNBQ==kTKUtCjVQgsgdfQP")
    @GET("animals?name=dragon")
    fun fetchDragonList(@Query("name") name: String): Call<List<Dragon>>

}