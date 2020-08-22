/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.data.source.remote

import retrofit2.Retrofit
import studio.elevenbox.koinmvvm.base.exception.Failure
import studio.elevenbox.koinmvvm.base.extension.toModel
import studio.elevenbox.koinmvvm.base.functional.Either
import studio.elevenbox.koinmvvm.base.platform.NetworkHandler
import studio.elevenbox.koinmvvm.data.model.Facts
import studio.elevenbox.koinmvvm.data.service.RemoteService

class RemoteDataSourceImpl(
    private val networkHandler: NetworkHandler,
    private val retrofit: Retrofit
) : RemoteDataSource {

    private val service: RemoteService by lazy {
        retrofit.create(RemoteService::class.java)
    }

    override suspend fun getFacts(): Either<Failure, Facts> {
        return if (networkHandler.isConnected()) {
            service.getFacts().toModel()
        } else Either.Left(Failure.NetworkError)
    }
}