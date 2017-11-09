package com.existentio.daggerexample.module;

import com.existentio.daggerexample.model.Engine;
import com.existentio.daggerexample.model.Vehicle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Flor on 09.11.2017.
 */


@Module
public class VehicleModule {

    @Provides
    @Singleton
    Engine provideMotor() {
        return new Engine();
    }

    @Provides
    @Singleton
    Vehicle provideVehicle() {
        return new Vehicle(new Engine());
    }

}
