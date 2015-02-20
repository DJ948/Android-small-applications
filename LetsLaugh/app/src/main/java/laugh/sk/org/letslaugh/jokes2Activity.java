package laugh.sk.org.letslaugh;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sk on 29-01-2015.
 */
public class jokes2Activity extends Activity {
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
        jokeList.add("santa:oye banta machli khayega..banta:nhi yaar usme bohot kante hote hai..santa:are yaar chappal pehenke kha lena");
        jokeList.add("ek bar santa ko koi 8th floor pe bulata hai..santa wahan jata hai toh wahan likha rehta hai\"santa april fool\"..fir santa wahan likh k gaya..\"mai toh yahan aya hi nhi tha\"");
        jokeList.add("santa:mere padosi ka bacha kho gaya banta:fir kya kia santa:maine kaha,google karlo,mil jaye toh download karlena");
        jokeList.add("santa pe bijli ka taar gir gaya..santa tadap tadap k marne hi wala tha ki use yaad aya bijli toh 2 din se band hai");
        jokeList.add("santa k umbrella me hole tha..kisine pu6a umbrella me hole q??, toh santa bola barish ruk jaye toh pata kaise chalega");
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke3_layout);

        tvJoke = (TextView) findViewById(R.id.tvJoke);
        jokeList = new ArrayList<String>();
    }
}
