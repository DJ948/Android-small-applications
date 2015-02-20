package laugh.sk.org.letslaugh;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by sk on 02-02-2015.
 */
public class laughActivity extends Activity {


    TextView tvJoke;
    ArrayList<String> jokes;
    int max;
    int min=0,current=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laugh_activity);
        jokes = new ArrayList<String>();
        tvJoke = (TextView)findViewById(R.id.tvJoke);
        max=tvJoke.length()-1;

    }
    @Override
    protected void onStart() {
        super.onStart();
        jokes.add("Joke 1");
        jokes.add("Joke 2");
        jokes.add("Joke 3");
        jokes.add("Joke 4");
        jokes.add("Joke 5");

    }

    public void changeJoke(View view){

        switch (view.getId())
        {

            case R.id.btnNext:
                tvJoke.setText(jokes.get(current++));
                break;

            case R.id.btnPrevious:
                tvJoke.setText(jokes.get(current--));
                break;
        }

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
