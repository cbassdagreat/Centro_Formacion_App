package cbassdagreat.github.centro_formacion_app.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cbassdagreat.github.centro_formacion_app.model.CursoDetalle
import cbassdagreat.github.centro_formacion_app.room.ProjectDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CursoDetalleRepo (var context: Context) {

    private val db= ProjectDB.getInstance(context)

    fun agregar(curso:CursoDetalle)
    {
        CoroutineScope(Dispatchers.IO).launch {
            db.cursoDetalle().agregar(curso)
        }
    }

    fun listar():LiveData<List<CursoDetalle>>
    {
        return db.cursoDetalle().listar()
    }

    fun buscar(id:String):CursoDetalle
    {
        return db.cursoDetalle().buscar(id)
    }
}