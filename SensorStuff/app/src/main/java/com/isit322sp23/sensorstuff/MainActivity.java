package com.isit322sp23.sensorstuff;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get sensor manager and assign it to its variable mSensorManager

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //Get the list of all sensors from the sensor manager
        //Store the list in a list object whose values are of the type Sensor

        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        //Iterate over the list of sensors.
        //For each sensor, get that sensor's official name with the getName() method
        //and append that name to the sensorText string
        //Each line of the sensor list is separated by the value of the line.separator property.
        //Typically a newline character

        StringBuilder sensorText = new StringBuilder();

        for (Sensor currentSensor : sensorList) {
            sensorText.append(currentSensor.getName()).append(
                    System.getProperty("line.separator"));
        }

        //Get a reference to the TextView for the sensor list
        //and update the text of that view with the string containing the list of sensors

        TextView sensorTextView = (TextView) findViewById(R.id.sensor_list);
        sensorTextView.setText(sensorText);

    }
}