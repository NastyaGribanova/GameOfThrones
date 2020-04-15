package com.example.gameofthrones.domain.model

data class House(
    var ancestralWeapons: List<String>,
    var cadetBranches: List<Any>,
    var coatOfArms: String,
    var currentLord: String,
    var diedOut: String,
    var founded: String,
    var founder: String,
    var heir: String,
    var name: String,
    var overlord: String,
    var region: String,
    var seats: List<String>,
    var swornMembers: List<String>,
    var titles: List<String>,
    var url: String,
    var words: String
)
