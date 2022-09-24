package cbassdagreat.github.centro_formacion_app.client

import cbassdagreat.github.centro_formacion_app.service.CursoService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClienteRetrofit {

    companion object{
        const val base_url="https://courses-fake-api.herokuapp.com/"
        private var cliente: Retrofit? = null

        fun getInstancia(url:String): CursoService{
            if(cliente==null)
            {
                cliente=Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build()
            }

            return cliente!!.create(CursoService::class.java)
        }
    }
}