package Models

import java.io.Serializable
import java.util.Objects

data class HistorialEnfermedadIdModel(
    val historial: Long,
    val enfermedad: Long
) : Serializable


