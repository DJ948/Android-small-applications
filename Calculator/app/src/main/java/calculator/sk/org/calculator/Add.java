package calculator.sk.org.calculator;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by sk on 10-02-2015.
 */
public class Add extends AsyncTask<Integer,Integer,String> {


    Activity activity;
    Add(Activity activity){
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Integer... params) {
        Integer num1 = params[0];
        Integer num2 = params[1];
        return (num1+num2)+"";
    }

    @Override
    protected void onPostExecute(String s) {

        TextView tvResult = (TextView) activity.findViewById(R.id.tvResult);
        tvResult.setText(s);
    }
}
