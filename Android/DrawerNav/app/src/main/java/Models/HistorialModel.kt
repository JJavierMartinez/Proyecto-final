package Models

import java.io.Serializable
import java.util.Date

data class HistorialModel(
    val id: Long? = null,
    val fecha_evento: Date,
    val tipo_evento: String,
    val notas: String,
    val paciente: PacienteModel,
    val enfermedades: List<HistorialEnfermedadModel> = emptyList()
) : Serializable
