package cbassdagreat.github.centro_formacion_app.client

import cbassdagreat.github.centro_formacion_app.FileReader
import com.google.common.truth.Truth
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

import org.junit.After
import org.junit.Before
import org.junit.Test

class ClienteRetrofitTest {

    private val server = MockWebServer()
    private val body = FileReader.fileReaderJson("curso.json")

    @Before
    fun setUp() {
        server.start(8080)
        server.enqueue(MockResponse().setResponseCode(200).setBody(body))
        server.url("courses_details/100")
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun test_apiSuccess()
    {
        val call = ClienteRetrofit.getInstancia("http://localhost:8080").getCursoDetalle("100")
        val curso = call.execute().body()
        Truth.assertThat(curso?.id).isEqualTo("100")
                }
}