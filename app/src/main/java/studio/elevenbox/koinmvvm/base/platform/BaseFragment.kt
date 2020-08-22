/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.base.platform

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import studio.elevenbox.koinmvvm.base.exception.Failure

abstract class BaseFragment : Fragment() {

    abstract fun layoutId(): Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(layoutId(), container, false)
    }

    open fun onBackPressed() {}

    protected fun onLoading(show: Boolean) {
        (activity as BaseActivity?)?.onLoading(show)
    }

//    protected fun notify(@StringRes message: Int) {
////        (activity as BaseActivity?)?.notify(message)
////    }

    protected fun notify(message: String) {
        (activity as BaseActivity?)?.notify(message)
    }

    protected open fun onFailure(failure: Failure) {
        (activity as BaseActivity?)?.onFailure(failure)
    }

    protected fun addFragment(fragment: BaseFragment, tag: String? = null) {
        (activity as BaseActivity?)?.addFragment(fragment, tag)
    }

    protected fun replaceFragment(fragment: BaseFragment, tag: String? = null) {
        (activity as BaseActivity?)?.replaceFragment(fragment, tag)
    }
}