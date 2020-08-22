/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.domain.entities

class FactEntity(
    val list: List<ItemEntity>
) {
    class ItemEntity(
        val id: String,
        val text: String,
        val votes: Int,
        val user: UserEntity
    ) {
        class UserEntity(
            val name: NameEntity
        ) {
            class NameEntity(
                val first: String,
                val last: String
            )
        }
    }
}