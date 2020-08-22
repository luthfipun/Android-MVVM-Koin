/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.mvvm.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import studio.elevenbox.koinmvvm.R
import studio.elevenbox.koinmvvm.base.extension.observe
import studio.elevenbox.koinmvvm.base.platform.BaseFragment
import studio.elevenbox.koinmvvm.mvvm.main.item.FactViewHolder
import studio.elevenbox.koinmvvm.mvvm.main.item.ItemFact

class MainFragment : BaseFragment(), FactViewHolder.ItemFactListener {

    private val viewModel: MainViewModel by viewModel()
    private val adapter = MainAdapter()

    override fun layoutId() = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        initView()
    }

    private fun initView() {
        viewModel.getFacts()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        recyclerView.adapter = adapter
        adapter.itemFactListener = this
    }

    private fun observeLiveData() = with(viewModel) {
        observe(data) { adapter.add(it) }
        observe(loading, ::onLoading)
    }

    override fun onItemFactTapped(itemFact: ItemFact) {
        notify("${itemFact.id} Tapped!")
    }
}