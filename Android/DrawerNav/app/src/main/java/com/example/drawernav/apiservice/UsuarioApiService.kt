package com.example.drawernav.apiservice

import Models.CitaModel
import Models.PacienteModel
import Models.UsuarioModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UsuarioApiService {
    @GET("usuarios/username/{user}")
    fun getUsuarioByNombre(@Path("user") user: String): Call<UsuarioModel>

    @GET("pacientes/dueno/{userId}")
    fun getMascotasDeUsuario(@Path("userId") userId: Long ?): Call<List<PacienteModel>>

    @GET("citas")
    fun getTodasLasCitas(): Call<List<CitaModel>>

    @GET("pacientes")
    fun getTodosLosPacientes(): Call<List<PacienteModel>>

    @POST("usuarios")
    fun crearUsuario(@Body usuario: UsuarioModel): Call<UsuarioModel>


}