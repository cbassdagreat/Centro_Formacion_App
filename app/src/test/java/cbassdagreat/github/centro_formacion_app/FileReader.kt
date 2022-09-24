package cbassdagreat.github.centro_formacion_app

import java.io.File
import java.io.InputStreamReader
import java.lang.StringBuilder

object FileReader {

    fun fileReaderJson(file:String):String{
        val input = File("src/main/assets/$file").inputStream()
        val builder = StringBuilder()
        val fileReader = InputStreamReader(input,"UTF-8")
        fileReader.readLines().forEach {
            builder.append(it)
        }
        return builder.toString()
    }
}