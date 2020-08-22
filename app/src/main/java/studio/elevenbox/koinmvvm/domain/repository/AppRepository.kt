/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.domain.repository

import studio.elevenbox.koinmvvm.base.exception.Failure
import studio.elevenbox.koinmvvm.base.functional.Either
import studio.elevenbox.koinmvvm.domain.entities.FactEntity

interface AppRepository {

    suspend fun getFacts(): Either<Failure, FactEntity>
}