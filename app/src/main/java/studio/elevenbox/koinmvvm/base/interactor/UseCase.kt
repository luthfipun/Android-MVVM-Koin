/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.base.interactor

import studio.elevenbox.koinmvvm.base.exception.Failure
import studio.elevenbox.koinmvvm.base.functional.Either

abstract class UseCase<SuccessType : Any, in Params> {

    abstract suspend fun build(params: Params?): Either<Failure, SuccessType>

    suspend fun execute(params: Params? = null) = build(params)
}