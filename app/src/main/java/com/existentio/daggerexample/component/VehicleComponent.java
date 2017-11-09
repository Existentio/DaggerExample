package com.existentio.daggerexample.component;

import android.app.Activity;

import com.existentio.daggerexample.MainActivity;
import com.existentio.daggerexample.module.VehicleModule;
import com.existentio.daggerexample.model.Vehicle;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Flor on 09.11.2017.
 */

@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {
    Vehicle provideVehicle();
}
