package com.example.rickandmorty.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.rickandmorty.data.pojo.CharacterInfoModel
import com.example.rickandmorty.domain.characters.CharacterLocation
import com.example.rickandmorty.domain.characters.CharacterObject
import com.example.rickandmorty.domain.characters.CharacterOrigin

class CharactersListMapper {

    private fun mapEntityToDataBaseModel(characterObject: CharacterObject) = CharacterInfoModel(
        id = characterObject.id,
        name = characterObject.name,
        status = characterObject.status,
        species = characterObject.species,
        type = characterObject.type,
        gender = characterObject.gender,
        origin = characterObject.origin.toString(),
        location = characterObject.location.toString(),
        image = characterObject.image,
        episode = characterObject.episode.toString().replace("[", "").replace("]", ""),
        url = characterObject.url,
        created = characterObject.created
    )

    fun mapDataBaseModelToObjectEntity(character: CharacterInfoModel) = CharacterObject(
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        type = character.type,
        gender = character.gender,
        origin = stringToOriginObject(character.origin),
        location = stringToLocationObject(character.location),
        image = character.image,
        episode = ArrayList(character.episode.trim().split("")),
        url = character.url,
        created = character.created
    )

    fun mapListDataBaseModelToListEntity(liveDataList: LiveData<List<CharacterInfoModel>>) =
        liveDataList.map {
            it.map { character -> mapDataBaseModelToObjectEntity(character) }
        }

    fun mapListEntityToListDataBaseModel(entityList: List<CharacterObject>) =
        entityList.map { character -> mapEntityToDataBaseModel(character) }

    private fun stringToOriginObject(string: String): CharacterOrigin {
        val array = string.split(",").toTypedArray()
        return CharacterOrigin(array[0], array[1])
    }

    private fun stringToLocationObject(string: String): CharacterLocation {
        val array = string.split(",").toTypedArray()
        return CharacterLocation(array[0], array[1])
    }

//    fun mapDataBaseModelToLiveDataEntity(character: LiveData<CharacterInfoModel>): LiveData<CharacterObject> {
//        var characterObject: LiveData<CharacterObject>
//        character.value = CharacterObject(
//            id = character.value?.id ?: -1,
//            name = character.value?.name ?: "",
//            status = character.value?.status ?: "",
//            species = character.value?.species ?: "",
//            type = character.value?.type ?: "",
//            gender = character.value?.gender ?: "",
//            origin = stringToOriginObject(character.value?.origin ?: ""),
//            location = stringToLocationObject(character.value?.location ?: ""),
//            image = character.value?.image ?: "",
//            episode = character.value?.episode?.trim()?.split(",")?.toTypedArray() ?: emptyArray(),
//            url = character.value?.url ?: "",
//            created = character.value?.created ?: ""
//        )
//        return characterObject
//
//    }

}

