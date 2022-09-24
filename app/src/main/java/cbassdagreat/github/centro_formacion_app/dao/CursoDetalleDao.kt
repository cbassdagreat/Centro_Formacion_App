package cbassdagreat.github.centro_formacion_app.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import cbassdagreat.github.centro_formacion_app.model.CursoDetalle

@Dao
interface CursoDetalleDao {

    @Insert(onConflict = REPLACE)
    fun agregar(cursoDetalle:CursoDetalle)

    @Query("select description, id, image, minimumSkill, modality, scholarshipsAvailable, start, title, tuition, weeks from curso_full where id= :id")
    fun buscar(id:String):CursoDetalle

    @Query("select description, id, image, minimumSkill, modality, scholarshipsAvailable, start, title, tuition, weeks from curso_full")
    fun listar():LiveData<List<CursoDetalle>>
}