/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.base.injection

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import studio.elevenbox.koinmvvm.BuildConfig.BASE_URL
import studio.elevenbox.koinmvvm.BuildConfig.DEBUG
import studio.elevenbox.koinmvvm.base.platform.NetworkHandler
import studio.elevenbox.koinmvvm.data.source.local.LocalDataSource
import studio.elevenbox.koinmvvm.data.source.local.LocalDataSourceImpl
import studio.elevenbox.koinmvvm.data.source.remote.RemoteDataSource
import studio.elevenbox.koinmvvm.data.source.remote.RemoteDataSourceImpl
import studio.elevenbox.koinmvvm.domain.repository.AppRepository
import studio.elevenbox.koinmvvm.domain.repository.AppRepositoryImpl
import studio.elevenbox.koinmvvm.domain.usecase.FactUseCase
import studio.elevenbox.koinmvvm.mvvm.main.MainViewModel

private val gsonBuilder = GsonBuilder().create()

val applicationModule = module {

    single { NetworkHandler(androidContext()) }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
            .build()
    }

    single {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (DEBUG) {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }

        okHttpClientBuilder.build() as OkHttpClient
    }

    single<LocalDataSource> { LocalDataSourceImpl() }
    single<RemoteDataSource> { RemoteDataSourceImpl(get(), get()) }
    single<AppRepository> { AppRepositoryImpl(get(), get()) }

    single { FactUseCase(get()) }

    viewModel { MainViewModel(get()) }
}