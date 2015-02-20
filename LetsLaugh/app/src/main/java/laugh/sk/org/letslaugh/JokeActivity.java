package laugh.sk.org.letslaugh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by sk on 29-01-2015.
 */
public class JokeActivity extends Activity {

    public void navigate(View view){

        switch(view.getId()){


            case R.id.btnRajni: Intent intent1 = new Intent(getBaseContext(),JokesActivity.class);
                                startActivity(intent1);

                                break;

            case R.id.btncid:   Intent intent2 = new Intent(getBaseContext(),jokes1Activity.class);
                                startActivity(intent2);
                                break;

            case R.id.btnSanta: Intent intent3 = new Intent(getBaseContext(),jokes2Activity.class);
                                startActivity(intent3);
                                break;

        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
