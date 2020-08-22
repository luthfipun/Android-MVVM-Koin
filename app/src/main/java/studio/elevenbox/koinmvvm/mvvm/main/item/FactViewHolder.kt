/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.mvvm.main.item

import android.view.View
import studio.elevenbox.koinmvvm.base.platform.BindableViewHolder
import studio.elevenbox.koinmvvm.databinding.ItemFactBinding

class FactViewHolder(
    view: View
) : BindableViewHolder<ItemFactBinding, ItemFact>(view) {
    override fun bind(viewModel: ItemFact) {
        binding?.data = viewModel
    }

    interface ItemFactListener {
        fun onItemFactTapped(itemFact: ItemFact)
    }
}