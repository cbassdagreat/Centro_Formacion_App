package cbassdagreat.github.centro_formacion_app.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cbassdagreat.github.centro_formacion_app.dao.CursoDetalleDao
import cbassdagreat.github.centro_formacion_app.dao.CursoItemDao
import cbassdagreat.github.centro_formacion_app.model.CursoDetalle
import cbassdagreat.github.centro_formacion_app.model.CursosItem

@Database(entities = [CursosItem::class, CursoDetalle::class], version = 1)
abstract class ProjectDB : RoomDatabase() {



    abstract fun cursoItem() : CursoItemDao
    abstract fun cursoDetalle() :CursoDetalleDao

    companion object{
        @Volatile
        private var instance:ProjectDB?=null

        fun getInstance(context: Context):ProjectDB
        {
            if(instance==null)
            {
                synchronized(this)
                {
                    instance = Room.databaseBuilder(context,ProjectDB::class.java,"project_db").build()
                }

            }

            return instance!!
        }
    }

}