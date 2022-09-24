package cbassdagreat.github.centro_formacion_app.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cbassdagreat.github.centro_formacion_app.model.ListaCursos
import cbassdagreat.github.centro_formacion_app.model.CursosItem
import cbassdagreat.github.centro_formacion_app.room.ProjectDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CursoRepo (var context: Context) {

    private val db=ProjectDB.getInstance(context)

    fun agregar(lista:ListaCursos)
    {
        CoroutineScope(Dispatchers.IO).launch {
            db.cursoItem().agregar(lista)
        }
    }

    fun listar():LiveData<List<CursosItem>>
    {
        return db.cursoItem().listar()
    }
}