package com.example.gameofthrones.data.api.models

import com.google.gson.annotations.SerializedName

data class CharacterApi(
    @SerializedName("aliases")
    var aliases: List<String>,
    @SerializedName("allegiances")
    var allegiances: List<Any>,
    @SerializedName("books")
    var books: List<String>,
    @SerializedName("born")
    var born: String,
    @SerializedName("culture")
    var culture: String,
    @SerializedName("died")
    var died: String,
    @SerializedName("father")
    var father: String,
    @SerializedName("gender")
    var gender: String,
    @SerializedName("mother")
    var mother: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("playedBy")
    var playedBy: List<String>,
    @SerializedName("povBooks")
    var povBooks: List<Any>,
    @SerializedName("spouse")
    var spouse: String,
    @SerializedName("titles")
    var titles: List<String>,
    @SerializedName("tvSeries")
    var tvSeries: List<String>,
    @SerializedName("url")
    var url: String
)
