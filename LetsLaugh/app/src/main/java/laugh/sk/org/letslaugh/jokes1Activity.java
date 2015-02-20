package laugh.sk.org.letslaugh;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sk on 29-01-2015.
 */
public class jokes1Activity extends Activity implements SensorEventListener {

    TextView tvJoke;
    ArrayList<String> jokeList;
    int current=0;
    int current1;
    private static final int SHAKE_THRESHOLD = 800;

    SensorManager sensorManager;
    TextView tvSensorData;
    Sensor sensor;
    long lastUpdate;
    float x,y,z;
    float last_x,last_y,last_z;

    public void changeJoke(View view){

        switch (view.getId()){

            case R.id.btnRight: try {
                tvJoke.setText(jokeList.get(current));
                current1=current-1;
                current++;
            }catch(Exception e){
                tvJoke.setText("no more jokes..press previous button");
                current1=jokeList.size()-1;
            }
                break;
            case R.id.btnLeft: try {

                tvJoke.setText(jokeList.get(current1));
                current = current1+1;
                current1--;

            }catch(Exception e){
                tvJoke.setText("press next button");
                current=0;
            }
                break;
        }



    }

    @Override
    protected void onStart() {
        super.onStart();

        sensorManager.registerListener(this,sensor,sensorManager.SENSOR_DELAY_NORMAL);

        jokeList.add("Good Morning Ke Baad Afternoon Hua Hai, Good Morning ke Baad Afternoon Hua Hai, Daya Ye Sadharan Maut Nahi Iska Khoon Hua Hai");
        jokeList.add("A For Apple B For Banana,A For Apple B For Banana,A.c.p. Ne Kaha Daya Goli Mat Chalana....");
        jokeList.add("Raat Ke Pehlu Me Chand Sittare Chaye He,Wah Wah,Raat Ke Pehlu Me Chand Sittare Chaye He,Madam Darwaja Kholiye Hum Cid Se Aaye He");
        jokeList.add("Tumhari Biwi Ki Bahen Tumhari Sali He,Wah Wah,Tumhari Biwi ki Bahen Tumhari Sali He,Wah Wah,Acp Says: Daya Ye Pistol To Khali Hai.");
        jokeList.add("Swimming Pool Mein Paani Bohot Gehra Hai,Daya Says-sir Lagta Hai Yeh Aadmi Iss Hotel Mein Kisi Dusre Naam Se Thehra Hai.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this,sensor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke1_layout);

        tvJoke = (TextView) findViewById(R.id.tvJoke);
        jokeList = new ArrayList<String>();

        sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        tvSensorData = (TextView) findViewById(R.id.tvSensorData);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float [] values = event.values;
        //tvSensorData.setText(values[0]+" "+values[1]+" "+values[2]);

        long curTime = System.currentTimeMillis();
        // only allow one update every 100ms.
        if ((curTime - lastUpdate) > 100) {
            long diffTime = (curTime - lastUpdate);
            lastUpdate = curTime;

            x = values[SensorManager.DATA_X];
            y = values[SensorManager.DATA_Y];
            z = values[SensorManager.DATA_Z];

            float speed = Math.abs(x+y+z - last_x - last_y - last_z) / diffTime * 10000;

            if (speed > SHAKE_THRESHOLD) {

                try {
                    tvJoke.setText(jokeList.get(current));
                    current1=current-1;
                    current++;
                }catch(Exception e){
                    tvJoke.setText("no more jokes..press previous button");
                    current1=jokeList.size()-1;
                }

            }
            last_x = x;
            last_y = y;
            last_z = z;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
