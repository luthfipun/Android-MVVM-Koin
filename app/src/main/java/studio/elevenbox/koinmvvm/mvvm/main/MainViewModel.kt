/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.mvvm.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import studio.elevenbox.koinmvvm.base.platform.BaseViewModel
import studio.elevenbox.koinmvvm.base.platform.CommonListItemViewModel
import studio.elevenbox.koinmvvm.domain.usecase.FactUseCase
import studio.elevenbox.koinmvvm.mvvm.main.item.ItemFact

class MainViewModel(
    private val factUseCase: FactUseCase
) : BaseViewModel() {

    private val _data = MutableLiveData<List<CommonListItemViewModel>>()
    val data: LiveData<List<CommonListItemViewModel>> = _data

    fun getFacts() = viewModelScope.launch {
        _loading.value = true
        val get = withContext(Dispatchers.IO) {
            factUseCase.execute()
        }

        get.either(::handleFailure) {
            _loading.value = false
            if (it.list.isNotEmpty()) {
                val mutableData = mutableListOf<CommonListItemViewModel>()
                it.list.map { item -> mutableData.add(ItemFact.create(item)) }
                _data.value = mutableData
            }
        }
    }
}