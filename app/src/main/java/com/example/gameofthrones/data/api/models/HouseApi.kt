package com.example.gameofthrones.data.api.models

import com.google.gson.annotations.SerializedName

data class HouseApi(
    @SerializedName("ancestralWeapons")
    var ancestralWeapons: List<String>,
    @SerializedName("cadetBranches")
    var cadetBranches: List<Any>,
    @SerializedName("coatOfArms")
    var coatOfArms: String,
    @SerializedName("currentLord")
    var currentLord: String,
    @SerializedName("diedOut")
    var diedOut: String,
    @SerializedName("founded")
    var founded: String,
    @SerializedName("founder")
    var founder: String,
    @SerializedName("heir")
    var heir: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("overlord")
    var overlord: String,
    @SerializedName("region")
    var region: String,
    @SerializedName("seats")
    var seats: List<String>,
    @SerializedName("swornMembers")
    var swornMembers: List<String>,
    @SerializedName("titles")
    var titles: List<String>,
    @SerializedName("url")
    var url: String,
    @SerializedName("words")
    var words: String
)
