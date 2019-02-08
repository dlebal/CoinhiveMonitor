package dlebal.es.coinhivemonitor.api.coinhive.model

import com.google.gson.annotations.SerializedName

/**
 * Class data class CoinhiveSite
 *
 * This class provides CoinhiveSite objects
 */
data class CoinhiveSite(
    @SerializedName("hashesPerSecond")
    val hashesPerSecond: Long = 0,
    @SerializedName("hashesTotal")
    val hashesTotal: Long = 0,
    @SerializedName("xmrPending")
    val xmrPending: Double = 0.0,
    @SerializedName("xmrPaid")
    val xmrPaid: Double = 0.0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("history")
    val history: List<CoinhiveSiteHistory> = ArrayList(),
    @SerializedName("success")
    val success: Boolean = false,
    @SerializedName("error")
    val error: String = ""
)
