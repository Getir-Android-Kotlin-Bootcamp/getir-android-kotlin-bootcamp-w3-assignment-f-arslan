package com.getir.patika.foodcouriers.ext

import com.getir.patika.foodcouriers.ui.location.Location
import com.getir.patika.foodcouriers.ui.location.LocationResult
import com.google.android.libraries.places.api.model.Place

fun Place.toSuccessLocationResult(): LocationResult {
    val latLng = requireNotNull(latLng) { "LatLng is null" }
    return LocationResult.Success(
        Location(
            latLng.latitude,
            latLng.longitude,
            address ?: "",
            name ?: ""
        )
    )
}
