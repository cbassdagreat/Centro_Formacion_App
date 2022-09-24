package cbassdagreat.github.centro_formacion_app.service

import cbassdagreat.github.centro_formacion_app.model.CursoDetalle
import cbassdagreat.github.centro_formacion_app.model.ListaCursos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CursoService {

    @GET("courses")
    fun getCursos(): Call<ListaCursos>

    @GET("courses_details/{id}")
    fun getCursoDetalle(@Path("id") id: String) : Call<CursoDetalle>
}