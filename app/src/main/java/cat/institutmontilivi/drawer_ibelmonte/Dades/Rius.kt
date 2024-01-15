package cat.institutmontilivi.categoriesnavigation.Dades

data class Riu(
    val foto: String,
    val id: Int,
    val nom: String,
    val caudal: Int,
    val longitud: Int
)
class Rius{
    companion object{
        var dades = CreaRius()
        fun CreaRius(): List<Riu> {
            return (1..50).map { i->
                Riu(
                    "https://loremflickr.com/300/300/river/?lock=${i + 150}",
                    i,
                    "Riu $i",
                    (100..500).random(),
                    (100..10000).random()
                )
            }
        }
    }
}