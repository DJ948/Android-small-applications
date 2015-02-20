package calculator.sk.org.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by sk on 11-02-2015.
 */
public class FlashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flash_layout);

        Runnable obj = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getBaseContext(),CalculatorActivity.class);
                startActivity(intent);
                finish();
            }
        };

        Handler handler = new Handler();
        handler.postDelayed(obj,3000);

    }
}
