package Models

import java.util.Date

data class CitaModel(
    val id: Long? = null,
    val motivo: String,
    val fecha: Date,
    val usuario: UsuarioModel,
    val pago: PagoModel? = null,
    val paciente: PacienteModel
)
