/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.base.extension

import retrofit2.Response
import studio.elevenbox.koinmvvm.base.exception.Failure
import studio.elevenbox.koinmvvm.base.functional.Either

fun <T : Any> Response<T>.toModel(): Either<Failure, T> {

    val result = body()

    return if (isSuccessful) {
        if (result != null) {
            Either.Right(result)
        } else {
            Either.Left(Failure.MappingError)
        }
    } else {
        Either.Left(Failure.ServerError)
    }
}