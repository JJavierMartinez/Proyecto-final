package Models

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.Date

data class UsuarioModel(
    val id: Long? = null,
    val apellidos: String,
    @SerializedName("dni") val DNI: String,
    @SerializedName("user") val user: String,
    @SerializedName("fecha_nac") val fecha_nac: Date ?,
    @SerializedName("fecha_alta") val fecha_alta: Date ?,
    val telefono: String,
    val correo: String,
    val contrasena: String,
    val rol: RolModel,
    val pacientes: List<PacienteModel> ?= emptyList(),
    val citas: List<CitaModel> ?= emptyList()
) : Serializable
