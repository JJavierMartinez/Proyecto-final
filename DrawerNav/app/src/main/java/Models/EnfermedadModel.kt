package Models

data class EnfermedadModel(
    val id: Long? = null,
    val nombre: String,
    val descripcion: String,
    val historiales: List<HistorialEnfermedadModel> = emptyList()
)
