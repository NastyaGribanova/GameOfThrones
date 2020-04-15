package com.example.gameofthrones.domain.models

data class Character(
    var aliases: List<String>,
    var allegiances: List<Any>,
    var books: List<String>,
    var born: String,
    var culture: String,
    var died: String,
    var father: String,
    var gender: String,
    var mother: String,
    var name: String,
    var playedBy: List<String>,
    var povBooks: List<Any>,
    var spouse: String,
    var titles: List<String>,
    var tvSeries: List<String>,
    var url: String
)
