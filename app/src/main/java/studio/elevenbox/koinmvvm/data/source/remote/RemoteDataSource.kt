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

import studio.elevenbox.koinmvvm.base.exception.Failure
import studio.elevenbox.koinmvvm.base.functional.Either
import studio.elevenbox.koinmvvm.data.model.Facts

interface RemoteDataSource {
    suspend fun getFacts(): Either<Failure, Facts>
}