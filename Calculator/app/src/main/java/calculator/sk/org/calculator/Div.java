package calculator.sk.org.calculator;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

/**
 * Created by sk on 10-02-2015.
 */
public class Div extends AsyncTask<Integer,Integer,String> {



    Activity activity;
    Div(Activity activity){

        this.activity = activity;
    }

    @Override
    protected String doInBackground(Integer... params) {
       Integer num1 = params[0];
       Integer num2 = params[1];

       Double f1 = (Double) ((double)((int)num1));
       Double f2 = (Double) ((double)((int)num2));
       Double num3;
        try{
          num3 = f1/f2;
            return num3+"";
        }catch (Exception e){
            return "infinity";
        }


    }

    @Override
    protected void onPostExecute(String s) {
        TextView tvResult = (TextView) activity.findViewById(R.id.tvResult);
        tvResult.setText(s);
    }
}
