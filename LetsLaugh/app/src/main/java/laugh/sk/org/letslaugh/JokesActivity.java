package laugh.sk.org.letslaugh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;

/**
 * Created by sk on 29-01-2015.
 */
public class JokesActivity extends Activity {

    TextView tvJoke;
    ArrayList<String> jokeList;
    int current=0;
    int current1;

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
        jokeList.add("Once Rajinikanth kicked a horse in the chin.. It's decendents were found to be giraffes");
        jokeList.add("When anyone says \"No one is Perfect\", Rajinikanth takes it as a personal insult");
        jokeList.add("When Alexander Bell invented the telephone, he already had 3 missed calls from Rajinikanth");
        jokeList.add("When Rajinikanth is playing cricket, the rain has to cancel its raining due to the match");
        jokeList.add("When Osama found that Rajinikanth is to help US to find him, he shot himself to death");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke1_layout);
        tvJoke = (TextView) findViewById(R.id.tvJoke);
        jokeList = new ArrayList<String>();

    }
}
