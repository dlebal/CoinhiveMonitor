package dlebal.es.coinhivemonitor.model

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

/**
 * Class class AppPreferences(context: Context)
 *
 * This class provides AppPreferences objects
 */
class AppPreferences() {

    /**
     * Constants
     */
    companion object {
        private const val SHARED_PREFERENCE_NAME = "SHARED_PREFERENCE_COINHIVE_MONITOR" // Shared preference name
        private const val SHARED_PREFERENCE_KEY_SITES = "SHARED_PREFERENCE_KEY_SITES" // Share preference key sites
    }

    /**
     * Variables
     */
    private lateinit var sharedPreferences: SharedPreferences // SharedPreferences
    private val className: String = AppPreferences::class.java.simpleName // Class name

    /**
     * Constructor constructor (context: Context) : this()
     *
     * Performs the following tasks:
     *   - Initialize the instances of the class AppPreferences
     *
     * Parameters:
     *   @param context: Context
     */
    constructor (context: Context) : this() {

        // Variables
        val methodName = "constructor" // Method name

        // Initialize the instances of the class SharedPreference
        Log.d("$className: $methodName", "Initialize the instances of the class SharedPreference")
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)

    }

    /**
     * Method fun addSite(site: String)
     *
     * Performs the following tasks:
     *   - Add a site
     *
     * Parameters:
     *   @param site: Site
     */
    fun addSite(site: String) {

        // Variables
        val methodName = "addSite" // Method name

        // Add a site
        Log.d("$className: $methodName", "Add a site")
        var sites: ArrayList<String>? = this.getSites()
        if (sites == null) {
            sites = ArrayList()
        }
        if (!sites.contains(site)) {
            sites.add(site)
            this.saveSites(sites)
        }

    }

    /**
     * Method fun removeSite(secret: String)
     *
     * Performs the following tasks:
     *   - Remove a site
     *
     * Parameters:
     *   @param site: Site
     */
    fun removeSite(site: String) {

        // Variables
        val methodName = "removeSite" // Method name

        // Remove a site
        Log.d("$className: $methodName", "Remove a site")
        val sites = this.getSites()
        if (sites != null) {
            sites.remove(site)
            this.saveSites(sites)
        }

    }

    /**
     * Method fun getSites(): ArrayList<String>?
     *
     * Performs the following tasks:
     *   - Return the sites
     *
     * Parameters:
     *   @return sites: Sites
     */
    fun getSites(): ArrayList<String>? {

        // Variables
        val methodName = "getSites" // Method name
        var sites: ArrayList<String>? = null // Sites

        // Return the sites
        Log.d("$className: $methodName", "Return the sites")
        if (this.sharedPreferences.contains(SHARED_PREFERENCE_KEY_SITES)) {
            val type = object : TypeToken<ArrayList<String>>() {}.type
            sites = Gson().fromJson(this.sharedPreferences.getString(SHARED_PREFERENCE_KEY_SITES, null), type)
        }
        return sites

    }

    /**
     * Method private fun saveSites(sites: ArrayList<String>)
     *
     * Performs the following tasks:
     *   - Save the sites
     *
     * Parameters:
     *   @param sites: Sites
     */
    private fun saveSites(sites: ArrayList<String>) {

        // Variables
        val methodName = "saveSites" // Method name

        // Variables
        val editor: SharedPreferences.Editor = this.sharedPreferences.edit() // Editor

        // Save the sites
        Log.d("$className: $methodName", "Save the sites")
        editor.putString(SHARED_PREFERENCE_KEY_SITES, Gson().toJson(sites))
        editor.apply()

    }

}
