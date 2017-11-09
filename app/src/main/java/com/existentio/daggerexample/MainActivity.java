package com.existentio.daggerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.existentio.daggerexample.component.DaggerVehicleComponent;
import com.existentio.daggerexample.component.VehicleComponent;
import com.existentio.daggerexample.model.Vehicle;
import com.existentio.daggerexample.module.VehicleModule;

public class MainActivity extends AppCompatActivity {


  private Vehicle vehicle;
  private TextView speedValue;
  private VehicleComponent component;
  private Button btnDefault, btnAccelerate;
  private View.OnClickListener oc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speedValue =  findViewById(R.id.tv);
        btnDefault = findViewById(R.id.btn_default);
        btnAccelerate = findViewById(R.id.btn_accelerate);

        component = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();
        vehicle = component.provideVehicle();

        oc = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_default:
                        callBrake();
                        break;

                    case R.id.btn_accelerate:
                        callIncrease(22);
                        break;
                }
            }
        };

        attachListeners(btnDefault, btnAccelerate);
    }

    public void attachListeners(View... views) {
        for (View v : views) {
            v.setOnClickListener(oc);
        }
    }

    public void callBrake(){
        vehicle.stop();
        speedValue.setText(String.valueOf(vehicle.getSpeed()));
    }

    public void callIncrease(int value){
        vehicle.increaseSpeed(value);
        speedValue.setText(String.valueOf(vehicle.getSpeed()));
    }
}
