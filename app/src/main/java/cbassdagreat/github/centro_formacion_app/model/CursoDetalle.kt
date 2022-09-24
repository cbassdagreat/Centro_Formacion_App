package cbassdagreat.github.centro_formacion_app.model


import com.google.gson.annotations.SerializedName

data class CursoDetalle(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("minimumSkill")
    val minimumSkill: String,
    @SerializedName("modality")
    val modality: String,
    @SerializedName("scholarshipsAvailable")
    val scholarshipsAvailable: Boolean,
    @SerializedName("start")
    val start: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("tuition")
    val tuition: String,
    @SerializedName("weeks")
    val weeks: Int
)