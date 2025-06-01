package Models

import java.sql.Date

data class PagoModel(
    val id: Long? = null,
    val monto: Float,
    val fecha: Date,
    val metodoPago: String,
    val citas: List<CitaModel> = emptyList()
)
