/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

/*
 * Created by Luthfi Abdul Azis
 */

package studio.elevenbox.koinmvvm.data.service

import retrofit2.Response
import retrofit2.http.GET
import studio.elevenbox.koinmvvm.data.model.Facts

interface RemoteService {

    @GET("facts")
    suspend fun getFacts(): Response<Facts>
}