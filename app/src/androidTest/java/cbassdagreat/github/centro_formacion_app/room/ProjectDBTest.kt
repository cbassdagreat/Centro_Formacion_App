package cbassdagreat.github.centro_formacion_app.room

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import cbassdagreat.github.centro_formacion_app.dao.CursoDetalleDao
import cbassdagreat.github.centro_formacion_app.model.CursoDetalle
import cbassdagreat.github.centro_formacion_app.repository.CursoDetalleRepo
import com.google.common.truth.Truth
import org.junit.After
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering

@RunWith(AndroidJUnit4::class)
class ProjectDBTest {

    @get:Rule
    var rule=InstantTaskExecutorRule()

    private lateinit var db:ProjectDB
    private lateinit var dao:CursoDetalleDao



    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,ProjectDB::class.java).allowMainThreadQueries().build()
        dao = db.cursoDetalle()

    }

    @After
    fun tearDown(){
        db.close()
    }

    @Test
    fun curso_agregar(){
        var cursoDetalle=CursoDetalle(
            "This course will provide you with all of the essentials to become a successful frontend web developer. You will learn to master HTML, CSS and front end JavaScript, along with tools like Git, VSCode and front end frameworks like Vue",
            "100",
            "https://user-images.githubusercontent.com/22780253/120053848-84763280-bffa-11eb-9d4c-a8f923e55d75.jpg",
        "beginner",
        "bootcamp",
            true,
        "november 2021",
        "Front End Web Development",
        "$800.000",
        8
        )
        dao.agregar(cursoDetalle)
        var respuesta=dao.buscar("100")
        Truth.assertThat(respuesta).isEqualTo(cursoDetalle)
    }
}