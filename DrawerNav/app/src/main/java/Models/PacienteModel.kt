package Models

import java.util.Date

data class PacienteModel(
    val id: Long? = null,
    val nombre: String,
    val apellidos: String,
    val dniMascota: String,
    val fecha_nac: Date,
    val seguro: Boolean,
    val especie: String,
    val raza: String,
    val fecha_registro: Date,
    val historial: List<HistorialModel> = emptyList(),
    val dueno: UsuarioModel
)
