package dlebal.es.coinhivemonitor.api.coinhive

import dlebal.es.coinhivemonitor.api.coinhive.model.CoinhiveSite
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface interface CoinhiveApiService
 *
 * This interface provides CoinhiveApiService objects
 */
interface CoinhiveApiService {

    /**
     * Constants
     */
    companion object {
        const val COINHIVE_API_BASE_URL = "https://api.coinhive.com"
    }

    // Url for get a site
    @GET("/stats/site")
    fun getSite(@Query("secret") site: String): Call<CoinhiveSite>

}
