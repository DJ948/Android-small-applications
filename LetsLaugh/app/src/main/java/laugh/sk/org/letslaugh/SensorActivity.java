package laugh.sk.org.letslaugh;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;


public class SensorActivity extends ActionBarActivity {

    SensorManager sensorManager;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensor_layout);

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        tvResult = (TextView) findViewById(R.id.tvResult);
    }


    @Override
    protected void onStart() {
        super.onStart();

        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder data = new StringBuilder();

        for(Sensor sensor:sensorList){

            data.append(sensor.getName()+"\n"+sensor.getVendor()+"\n"+sensor.getPower()+"\n"+sensor.getType()+"\n--------------\n");

        }

        tvResult.setText(data.toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sensor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
