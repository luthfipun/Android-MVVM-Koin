/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.base.platform

interface CommonListItemViewModel

class LoadingItem(val nextPage: Int? = null) : CommonListItemViewModel {

    interface LoadingListener {
        fun onLoading(nextPage: Int? = null)
    }
}

object DividerItem : CommonListItemViewModel

object SmallDividerItem : CommonListItemViewModel