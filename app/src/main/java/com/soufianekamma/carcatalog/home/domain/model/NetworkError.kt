package com.soufianekamma.carcatalog.home.domain.model

data class NetworkError(
    val error: ApiError,
    val t: Throwable? = null
)

enum class ApiError(val message: String) {
    NetworkError("Veuillez vérifier votre connexion Internet!"),
    UnknownError("Une erreur inattendue s'est produit, veuillez réessayer plus tard"),
    UnknownResponse("Response inconnue du serveur, veuillez réessayer plus tard"),
}
