/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.data.model

import com.google.gson.annotations.SerializedName
import studio.elevenbox.koinmvvm.domain.entities.FactEntity

class Facts(
    @SerializedName("all")
    val list: List<Item>?
) {
    fun factEntity(): FactEntity {
        return FactEntity(list = list?.map { it.toItemEntity() } ?: listOf())
    }

    class Item(
        @SerializedName("_id")
        val id: String,
        @SerializedName("text")
        val text: String,
        @SerializedName("upvotes")
        val votes: Int,
        @SerializedName("user")
        val user: User?
    ) {
        fun toItemEntity(): FactEntity.ItemEntity {
            return FactEntity.ItemEntity(
                id,
                text,
                votes,
                user = user?.toUserEntity() ?: FactEntity.ItemEntity.UserEntity(
                    FactEntity.ItemEntity.UserEntity.NameEntity(
                        "",
                        ""
                    )
                )
            )
        }

        class User(
            @SerializedName("name")
            val name: Name
        ) {
            fun toUserEntity(): FactEntity.ItemEntity.UserEntity {
                return FactEntity.ItemEntity.UserEntity(name = name.toNameEntity())
            }

            class Name(
                @SerializedName("first")
                val first: String,
                @SerializedName("last")
                val last: String
            ) {
                fun toNameEntity(): FactEntity.ItemEntity.UserEntity.NameEntity {
                    return FactEntity.ItemEntity.UserEntity.NameEntity(first, last)
                }
            }
        }
    }
}