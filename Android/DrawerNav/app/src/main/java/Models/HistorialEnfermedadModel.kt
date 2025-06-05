package Models

import java.io.Serializable
import java.util.Date

data class HistorialEnfermedadModel(
    val historial: HistorialModel,
    val enfermedad: EnfermedadModel,
    val fechaDiagnostico: Date,
    val estado: String,
    val tratamiento: String,
    val observaciones: String
) : Serializable
