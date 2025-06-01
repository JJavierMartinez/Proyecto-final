package Models

data class RolModel(
    val id: Long? = null,
    val rol: String,
    val descripcion: String,
    val usuarios: List<UsuarioModel> = emptyList()
)
