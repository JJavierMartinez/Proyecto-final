package Models

import java.io.Serializable

data class EnfermedadModel(
    val id: Long? = null,
    val nombre: String,
    val descripcion: String,
    val historiales: List<HistorialEnfermedadModel> = emptyList()
) : Serializable
