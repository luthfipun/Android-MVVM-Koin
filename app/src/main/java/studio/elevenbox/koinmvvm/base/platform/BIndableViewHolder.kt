/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.base.platform

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BindableViewHolder<out B : ViewDataBinding, in VM : CommonListItemViewModel>(
    view: View
) : RecyclerView.ViewHolder(view) {

    val binding: B? by lazy { DataBindingUtil.bind<B>(view) }

    protected abstract fun bind(viewModel: VM)

    fun setViewModel(viewModel: VM) {
        bind(viewModel)
        binding?.executePendingBindings()
    }

}

class BasicViewHolder(view: View) : RecyclerView.ViewHolder(view)