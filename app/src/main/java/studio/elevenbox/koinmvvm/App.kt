/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.multidex.MultiDexApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import studio.elevenbox.koinmvvm.base.injection.applicationModule

class App : MultiDexApplication(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()

        ProcessLifecycleOwner.get().lifecycle.addObserver(this)

        startKoin {
            androidContext(this@App)
            modules(listOf(applicationModule))
        }
    }
}