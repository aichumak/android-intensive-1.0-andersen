package com.example.rickandmorty.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.rickandmorty.data.pojo.CharacterInfoModel
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.CharacterLocation
import com.example.rickandmorty.domain.characters.CharacterOrigin

class CharactersListMapper {

    fun mapEntityToDataBaseModel(characterObject: CharacterObject) = CharacterInfoModel(
        id = characterObject.id,
        name = characterObject.name,
        status = characterObject.status,
        species = characterObject.species,
        type = characterObject.type,
        gender = characterObject.gender,
        origin = characterObject.origin.toString(),
        location = characterObject.location.toString(),
        image = characterObject.image,
        episode = characterObject.episode.toString(),
        url = characterObject.url,
        created = characterObject.created
    )

    fun mapDataBaseModelToEntity(character: CharacterInfoModel) = CharacterObject (
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        type = character.type,
        gender = character.gender,
        origin = stringToOriginObject(character.origin),
        location = stringToLocationObject(character.location),
        image = character.image,
        episode = arrayListOf(character.episode),
        url = character.url,
        created = character.created
    )

    fun mapListDataBaseModelToListEntity(liveDataList: LiveData<List<CharacterInfoModel>>) = liveDataList.map {
        it.map {character -> mapDataBaseModelToEntity(character)}
    }


    private fun stringToOriginObject(string: String): CharacterOrigin {
        val array= arrayListOf(string)
        return CharacterOrigin(array[0], array[1])
    }

    private fun stringToLocationObject(string: String): CharacterLocation {
        val array= arrayListOf(string)
        return CharacterLocation(array[0], array[1])
    }

}

