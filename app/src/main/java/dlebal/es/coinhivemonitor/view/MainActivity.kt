package dlebal.es.coinhivemonitor.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import dlebal.es.coinhivemonitor.R
import dlebal.es.coinhivemonitor.api.coinhive.CoinhiveApiService
import dlebal.es.coinhivemonitor.api.coinhive.CoinhiveApiService.Companion.COINHIVE_API_BASE_URL
import dlebal.es.coinhivemonitor.api.coinhive.model.CoinhiveSite
import dlebal.es.coinhivemonitor.model.AppPreferences
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// https://tutorial.eyehunts.com/android/retrofit-android-example-json-parser-kotlin/
// https://coinhive.com/documentation/http-api
// API: https://api.coinhive.com/stats/site?secret=odyDbKMPG9SlKU49Sx26wGPbn3WuwOyL
// https://github.com/juanchosaravia/KedditBySteps/tree/master/app/src/main/java/com/droidcba/kedditbysteps
// https://hk.saowen.com/a/a8c5862e22050b0799b83330f139e36dbeb0cc20067a519dc0912306cb8a06f6
// http://androidopentutorials.com/android-how-to-store-list-of-values-in-sharedpreferences/
// http://randomdotnext.com/retrofit-rxjava/
// https://www.codexpedia.com/android/doing-network-caching-with-retrofit-2-in-android/
// https://code.tutsplus.com/tutorials/connect-to-an-api-with-retrofit-rxjava-2-and-kotlin--cms-32133

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }


        val appPreferences = AppPreferences(this)

        appPreferences.addSite("odyDbKMPG9SlKU49Sx26wGPbn3WuwOyL")
        appPreferences.addSite("ttmNY6UQkJhn2hcaSUYCcv5F9Oy1VJUe")
        appPreferences.addSite("agJizteub755Xe3RRy3LCH5hSTklC1jD")
        appPreferences.addSite("5C5Ss71gtJfCjcLBlQgTWpdsPYmUWssR")
        appPreferences.addSite("lN8bR4EoAPdT1H0pnnkKmFyPkuWqcuao")







        getSites()
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        // https://github.com/juanchosaravia/KedditBySteps/tree/master/app/src/main/java/com/droidcba/kedditbysteps
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }



    private fun getSites() {

        val retrofit = Retrofit.Builder()
            .baseUrl(COINHIVE_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(CoinhiveApiService::class.java)


        val sites = AppPreferences(this).getSites()
        if (sites != null) {
            for (site in sites) {
                Log.d("aaaaallllñññ1111112", "---")
                Log.d("aaaaallllñññ1111113", site)

                val call = service.getSite(site)
                call.enqueue(object : Callback<CoinhiveSite> {
                    override fun onResponse(call: Call<CoinhiveSite>, response: Response<CoinhiveSite>) {
                        if (response.isSuccessful) {
                            val coinhiveSite = response.body()!!
                            Log.d("aaaaallllñññ", coinhiveSite.name)
                        } else {
                            // Error
                            Log.d("aaaaallllñññ", "ERROR")
                        }
                    }

                    override fun onFailure(call: Call<CoinhiveSite>, t: Throwable) {
                        // Error
                        Log.d("aaaaallllñññ", call.toString())
                    }
                })

            }
        }

    }


}
