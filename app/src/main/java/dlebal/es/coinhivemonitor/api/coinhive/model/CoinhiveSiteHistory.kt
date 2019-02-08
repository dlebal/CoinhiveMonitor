package dlebal.es.coinhivemonitor.api.coinhive.model

import com.google.gson.annotations.SerializedName

/**
 * Class data class CoinhiveSiteHistory
 *
 * This class provides CoinhiveSiteHistory objects
 */
data class CoinhiveSiteHistory(
    @SerializedName("time")
    val time: Long = 0,
    @SerializedName("hashesTotal")
    val hashesTotal: Long = 0,
    @SerializedName("hashesPerSecond")
    val hashesPerSecond: Double = 0.0
)
