/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.domain.usecase

import studio.elevenbox.koinmvvm.base.exception.Failure
import studio.elevenbox.koinmvvm.base.functional.Either
import studio.elevenbox.koinmvvm.base.interactor.UseCase
import studio.elevenbox.koinmvvm.domain.entities.FactEntity
import studio.elevenbox.koinmvvm.domain.repository.AppRepository

class FactUseCase(
    private val appRepository: AppRepository
) : UseCase<FactEntity, Unit>() {
    override suspend fun build(params: Unit?): Either<Failure, FactEntity> {
        return appRepository.getFacts()
    }
}