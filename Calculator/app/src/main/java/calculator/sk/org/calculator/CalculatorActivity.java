package calculator.sk.org.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class CalculatorActivity extends ActionBarActivity {

    TextView tvResult;
    EditText etFirst;
    EditText etSecond;

    Integer num1,num2;

    public void calculate(View view){

        switch(view.getId()){

            case R.id.btnAdd:

                try {
                    num1 = Integer.parseInt(etFirst.getText().toString());
                    num2 = Integer.parseInt(etSecond.getText().toString());
                }catch (Exception e){

                    num1=0;
                    num2=0;
                }
                Add add = new Add(this);
                add.execute(num1, num2);


                break;

            case R.id.btnSub:

                try {
                    num1 = Integer.parseInt(etFirst.getText().toString());
                    num2 = Integer.parseInt(etSecond.getText().toString());
                }catch (Exception e){

                    num1=0;
                    num2=0;
                }

                    Sub sub = new Sub(this);
                    sub.execute(num1,num2);


                break;

            case R.id.btnMul:

                try {
                    num1 = Integer.parseInt(etFirst.getText().toString());
                    num2 = Integer.parseInt(etSecond.getText().toString());
                }catch (Exception e){

                    num1=0;
                    num2=0;
                }
                    Mul mul = new Mul(this);
                    mul.execute(num1,num2);

                break;

            case R.id.btnDiv:

                try {
                    num1 = Integer.parseInt(etFirst.getText().toString());
                    num2 = Integer.parseInt(etSecond.getText().toString());
                }catch (Exception e){

                    num1=0;
                    num2=0;
                }

                    Div div = new Div(this);
                    div.execute(num1,num2);


                break;

            case R.id.btnReset:
                etFirst.setText("");
                etSecond.setText("");
                tvResult.setText("RESULT");
                break;

        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tvResult = (TextView)findViewById(R.id.tvResult);
        etFirst = (EditText)findViewById(R.id.etFirst);
        etSecond = (EditText)findViewById(R.id.etSecond);

    }



}
