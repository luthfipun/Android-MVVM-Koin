/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.mvvm.main.item

import studio.elevenbox.koinmvvm.base.platform.CommonListItemViewModel
import studio.elevenbox.koinmvvm.domain.entities.FactEntity

class ItemFact(
    val id: String,
    val text: String,
    val votes: Int,
    val author: String
) : CommonListItemViewModel {
    companion object {
        fun create(itemEntity: FactEntity.ItemEntity): ItemFact {
            return ItemFact(
                id = itemEntity.id,
                text = itemEntity.text,
                votes = itemEntity.votes,
                author = "${itemEntity.user.name.first} ${itemEntity.user.name.last}"
            )
        }
    }
}