/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.base.platform

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected var data = mutableListOf<CommonListItemViewModel>()

    fun add(data: List<CommonListItemViewModel>) {
        this.data = data as MutableList<CommonListItemViewModel>
        notifyDataSetChanged()
    }

    fun add(position: Int, data: List<CommonListItemViewModel>) {
        this.data = data as MutableList<CommonListItemViewModel>
        notifyDataSetChanged()
    }

    fun update(data: List<CommonListItemViewModel>) {
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    fun update(position: Int, data: List<CommonListItemViewModel>) {
        this.data.addAll(data)
        notifyItemChanged(position)
    }

    fun update(start: Int, itemCount: Int, data: List<CommonListItemViewModel>) {
        this.data.addAll(data)
        notifyItemRangeChanged(start, itemCount)
    }

    fun clear() {
        data.clear()
        data.removeAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }
}