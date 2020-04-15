package com.example.gameofthrones.data.mappers

import com.example.gameofthrones.data.api.models.HouseApi
import com.example.gameofthrones.domain.models.House

class HouseMapper {
    fun map(house: HouseApi): House{
        return with(house){
            House(ancestralWeapons, cadetBranches, coatOfArms, currentLord, diedOut, founded, founder, heir, name, overlord, region, seats, swornMembers, titles, url, words)
        }
    }
}
