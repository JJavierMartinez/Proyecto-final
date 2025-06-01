package Models

import java.util.Date

data class UsuarioModel(
    val id: Long? = null,
    val apellidos: String,
    val DNI: String,
    val user: String,
    val fecha_nac: Date,
    val fecha_alta: Date,
    val telefono: String,
    val correo: String,
    val contrasena: String,
    val rol: RolModel,
    val pacientes: List<PacienteModel> = emptyList(),
    val citas: List<CitaModel> = emptyList()
)
