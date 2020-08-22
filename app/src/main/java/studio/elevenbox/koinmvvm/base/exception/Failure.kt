/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.base.exception

sealed class Failure {
    object ServerError : Failure()
    object MappingError : Failure()
    object CacheError : Failure()
    object NetworkError : Failure()

    abstract class FeatureFailure : Failure()
}