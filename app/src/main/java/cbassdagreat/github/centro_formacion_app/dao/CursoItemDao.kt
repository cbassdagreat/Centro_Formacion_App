package cbassdagreat.github.centro_formacion_app.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cbassdagreat.github.centro_formacion_app.model.ListaCursos
import cbassdagreat.github.centro_formacion_app.model.CursosItem

@Dao
interface CursoItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun agregar(listaCursos: ListaCursos)

    @Query("select id, image, previewDescription, start, title, weeks from curso_resumen")
    fun listar():LiveData<List<CursosItem>>
}