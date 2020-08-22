/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
ˆ */

package studio.elevenbox.koinmvvm.domain.repository

import studio.elevenbox.koinmvvm.base.exception.Failure
import studio.elevenbox.koinmvvm.base.functional.Either
import studio.elevenbox.koinmvvm.base.functional.map
import studio.elevenbox.koinmvvm.data.source.local.LocalDataSource
import studio.elevenbox.koinmvvm.data.source.remote.RemoteDataSource
import studio.elevenbox.koinmvvm.domain.entities.FactEntity

class AppRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : AppRepository {

    override suspend fun getFacts(): Either<Failure, FactEntity> {
        return remoteDataSource.getFacts()
            .map { it.factEntity() }
    }
}