package cbassdagreat.github.centro_formacion_app.model


import com.google.gson.annotations.SerializedName

data class ListaCursosItem(
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("previewDescription")
    val previewDescription: String,
    @SerializedName("start")
    val start: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("weeks")
    val weeks: Int
)