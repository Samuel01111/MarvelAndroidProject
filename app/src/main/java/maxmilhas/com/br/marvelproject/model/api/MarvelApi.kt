package maxmilhas.com.br.marvelproject.model.api
//
//import com.google.gson.GsonBuilder
//import maxmilhas.com.br.marvelproject.extentions.md5
//import maxmilhas.com.br.marvelproject.model.api.entity.API_KEY
//import maxmilhas.com.br.marvelproject.model.api.entity.PRIVATE_KEY
//import maxmilhas.com.br.marvelproject.model.api.entity.Response
//import okhttp3.OkHttpClient
//import okhttp3.logging.HttpLoggingInterceptor
//import retrofit2.Retrofit
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.http.GET
//import retrofit2.http.Query
//import rx.Observable
//import java.util.*
//
//interface MarvelApi {
//    @GET("characters")
//    fun allCharacters(@Query(): Observable<Response>
//
//    companion object {
//        fun getService(): MarvelApi {
//            val logging = HttpLoggingInterceptor()
//            logging.level = HttpLoggingInterceptor.Level.BODY
//
//            val httpClient = OkHttpClient.Builder()
//            httpClient.addInterceptor(logging)
//            httpClient.addInterceptor { chain ->
//                val original = chain.request()
//                val originalHttpUrl = original.url()
//
//                val ts = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
//                val url = originalHttpUrl.newBuilder()
//                        .addQueryParameter("apikey", API_KEY)
//                        .addQueryParameter("ts", ts)
//                        .addQueryParameter("hash", "$ts$PRIVATE_KEY$API_KEY".md5())
//                        .build()
//
//                chain.proceed(original.newBuilder().url(url).build())
//            }
//
//            val gson = GsonBuilder().setLenient().create()
//            val retrofit = Retrofit.Builder()
//                    .baseUrl("http://gateway.marvel.com/v1/public/")
//                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create(gson))
//                    .client(httpClient.build())
//                    .build()
//
//            return retrofit.create<MarvelApi>(MarvelApi::class.java)
//        }
//    }
//}