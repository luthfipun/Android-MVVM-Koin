/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.base.platform

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_layout.*
import studio.elevenbox.koinmvvm.R
import studio.elevenbox.koinmvvm.R.id
import studio.elevenbox.koinmvvm.R.layout
import studio.elevenbox.koinmvvm.base.exception.Failure

abstract class BaseActivity : AppCompatActivity() {

    open fun layoutId(): Int? = null

    abstract fun fragment(): BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId() ?: layout.activity_layout)
        setFragment(savedInstanceState)
        settingToolbars()
    }

    private fun settingToolbars() {
        btnBack.setOnClickListener { onBackPressed() }
    }

    override fun onBackPressed() {
        (supportFragmentManager.findFragmentById(
            id.fragmentContainer
        ) as BaseFragment).onBackPressed()
        super.onBackPressed()
    }

    private fun setFragment(savedInstanceState: Bundle?) {

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(id.fragmentContainer, fragment())
                .commit()
        }
    }

    internal fun addFragment(fragment: BaseFragment, tag: String? = null) {

        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .add(id.fragmentContainer, fragment, tag)
            .commit()
    }

    internal fun replaceFragment(fragment: BaseFragment, tag: String? = null) {

        supportFragmentManager
            .beginTransaction()
            .replace(id.fragmentContainer, fragment, tag)
            .commit()
    }

    internal fun onLoading(show: Boolean) {
        progressContainer.visibility = if (show) View.VISIBLE else View.GONE
    }

//    internal fun notify(@StringRes message: Int) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//    }

    internal fun notify(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    /*
     * if you want to override this function, do it like this:
     * override fun onFailure(failure: Failure): Unit = when {
     *      Failure.ServerError -> notify()
     *      else -> super.onFailure(failure)
     * }
     */
    internal open fun onFailure(failure: Failure) {

        if (failure == Failure.NetworkError) {
            notify(resources.getString(R.string.connection_error))
        } else {
            notify(resources.getString(R.string.common_error))
        }
    }
}