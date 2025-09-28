package com.example.d4aspostrecitos.interfaces

import com.example.d4aspostrecitos.model.Producto
import retrofit2.http.GET

interface ProductoInterface {

    @GET("productos")
    suspend fun getAll(): List<Producto>
}