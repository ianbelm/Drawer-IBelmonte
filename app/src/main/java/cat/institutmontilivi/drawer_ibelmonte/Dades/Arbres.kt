package cat.institutmontilivi.categoriesnavigation.Dades

data class Arbre(
    val id: Int,
    val foto: String,
    val nom: String,
    val alturaMitja: Int
)
class Arbres{
    companion object{
        val dades = CreaArbres()

        fun CreaArbres(): List<Arbre> = (1..50).map { i ->
                Arbre(
                    i,
                    "https://loremflickr.com/300/300/tree/?lock=${i + 100}",
                    "Arbre $i",
                    (1..100).random()
                )
        }
    }
}