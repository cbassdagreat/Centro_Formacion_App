package cbassdagreat.github.centro_formacion_app.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import cbassdagreat.github.centro_formacion_app.model.ListaCursos
import cbassdagreat.github.centro_formacion_app.repository.ClienteRepo
import cbassdagreat.github.centro_formacion_app.repository.CursoDetalleRepo
import cbassdagreat.github.centro_formacion_app.repository.CursoRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CursoVM(application: Application) :AndroidViewModel(application) {
    private val clienteRepo = ClienteRepo()
    private val cursoRepo=CursoRepo(getApplication())
    private val cursoDetalleRepo = CursoDetalleRepo(getApplication())

    private val log = "ERROR_CALL"

    val listaCursos = cursoRepo.listar()
    val listaCursoDetalle=cursoDetalleRepo.listar()

    fun callCursoItem()
    {
        clienteRepo.getListaCursos().enqueue(object :Callback<ListaCursos>{
            override fun onResponse(call: Call<ListaCursos>, response: Response<ListaCursos>) {
                response.body().let {
                    cursoRepo.agregar(it!!)
                }
            }

            override fun onFailure(call: Call<ListaCursos>, t: Throwable) {
                Log.e(log,t.message.toString())
            }

        })

    }

}