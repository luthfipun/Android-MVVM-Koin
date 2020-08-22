/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.mvvm.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import studio.elevenbox.koinmvvm.R
import studio.elevenbox.koinmvvm.base.extension.inflate
import studio.elevenbox.koinmvvm.base.platform.BaseRecyclerViewAdapter
import studio.elevenbox.koinmvvm.mvvm.main.item.FactViewHolder
import studio.elevenbox.koinmvvm.mvvm.main.item.ItemFact

class MainAdapter : BaseRecyclerViewAdapter() {

    var itemFactListener: FactViewHolder.ItemFactListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FactViewHolder(parent.inflate(R.layout.item_fact))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = data[position]
        when {
            item is ItemFact && holder is FactViewHolder -> onBind(item, holder)
        }
    }

    private fun onBind(item: ItemFact, holder: FactViewHolder) {
        holder.setViewModel(item)
        holder.binding?.container?.setOnClickListener {
            itemFactListener?.onItemFactTapped(item)
        }
    }
}