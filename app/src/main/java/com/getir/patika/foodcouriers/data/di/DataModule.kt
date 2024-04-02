package com.getir.patika.foodcouriers.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.getir.patika.foodcouriers.R
import com.getir.patika.foodcouriers.data.LocationRepository
import com.getir.patika.foodcouriers.data.PreferencesRepository
import com.getir.patika.foodcouriers.data.impl.LocationDataSource
import com.getir.patika.foodcouriers.data.impl.PreferencesDataSource
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

/**
 * A Hilt module that provides data-related dependencies for the application.
 * This includes the Places API client, Preferences DataStore, and a coroutine dispatcher.
 */
@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun providePlacesClient(@ApplicationContext context: Context): PlacesClient {
        Places.initialize(context, context.getString(R.string.api_key))
        return Places.createClient(context)
    }

    @Singleton
    @Provides
    fun providePreferencesDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(
                produceNewData = { emptyPreferences() }
            ),
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { context.preferencesDataStoreFile(USER_PREFERENCES_NAME) }
        )
    }

    @Singleton
    @Provides
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    private const val USER_PREFERENCES_NAME = "user_preferences"
}

/**
 * A Hilt module that binds data source implementations to their respective interfaces.
 */
@Module
@InstallIn(SingletonComponent::class)
interface DataModuleBinder {
    @Binds
    fun bindPreferencesRepository(impl: PreferencesDataSource): PreferencesRepository

    @Binds
    fun bindLocationRepository(impl: LocationDataSource): LocationRepository
}
