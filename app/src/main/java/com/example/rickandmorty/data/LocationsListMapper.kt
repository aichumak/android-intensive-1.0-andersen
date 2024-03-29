package com.example.rickandmorty.data

import com.example.rickandmorty.data.pojo.LocationInfoModel
import com.example.rickandmorty.domain.locations.LocationObject

class LocationsListMapper {

    private fun mapEntityToDataBaseModel(locationObject: LocationObject) = LocationInfoModel(
        id = locationObject.id,
        name = locationObject.name,
        type = locationObject.type,
        dimension = locationObject.dimension,
        residents = locationObject.residents.toString().replace("[", "").replace("]", ""),
        url = locationObject.url,
        created = locationObject.created
    )

    fun mapDataBaseModelToEntity(locationInfoModel: LocationInfoModel) = LocationObject(
        id = locationInfoModel.id,
        name = locationInfoModel.name,
        type = locationInfoModel.type,
        dimension = locationInfoModel.dimension,
        residents = ArrayList(locationInfoModel.residents.replace(" ", "").split(",")),
        url = locationInfoModel.url,
        created = locationInfoModel.created
    )

    fun mapListDataBaseModelToListEntity(liveDataList: List<LocationInfoModel>) =
        liveDataList.map { location -> mapDataBaseModelToEntity(location) }

    fun mapListEntityToListDataBaseModel(entityList: List<LocationObject>) =
        entityList.map { location -> mapEntityToDataBaseModel(location) }
}

