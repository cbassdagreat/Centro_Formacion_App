package cbassdagreat.github.centro_formacion_app.repository

import cbassdagreat.github.centro_formacion_app.client.ClienteRetrofit
import cbassdagreat.github.centro_formacion_app.model.CursoDetalle
import cbassdagreat.github.centro_formacion_app.model.ListaCursos
import retrofit2.Call

class ClienteRepo {

    private val cliente = ClienteRetrofit.getInstancia(ClienteRetrofit.base_url)

    fun getCursoDetalle(id:String): Call<CursoDetalle>
    {
        return cliente.getCursoDetalle(id)
    }

    fun getListaCursos():Call<ListaCursos>
    {
        return cliente.getCursos()
    }
}