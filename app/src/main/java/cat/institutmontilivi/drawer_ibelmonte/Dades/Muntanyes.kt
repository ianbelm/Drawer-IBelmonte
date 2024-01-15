package cat.institutmontilivi.categoriesnavigation.Dades

data class Muntanya(
    val id: Int,
    val nom: String,
    val foto: String,
    val altura: Int,
    val longitud: Int,
    val latitud: Int
)
class Muntanyes {
    companion object{
        var dada = CreaMunt()
        fun CreaMunt(): List<Muntanya> {
            return (1..50).map { i ->
                Muntanya(
                    i,
                    "Muntanya $i",
                    "https://loremflickr.com/300/300/mountain/?lock=${i + 150}",
                    (900..9000).random(),
                    (1..1000).random(),
                    (1..1000).random()
                )
            }
        }
    }
}