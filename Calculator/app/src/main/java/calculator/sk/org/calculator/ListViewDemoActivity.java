package calculator.sk.org.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sk on 17-02-2015.
 */
public class ListViewDemoActivity extends Activity {

    ListView lvResult;
    ArrayAdapter<String> listAdapter;
    ArrayList<String> listOfColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_layout);
        lvResult = (ListView) findViewById(R.id.lvResult);

        listOfColors = new ArrayList<String>();
        listOfColors.add("blue");
        listOfColors.add("red");
        listOfColors.add("yellow");
        listOfColors.add("green");
        listOfColors.add("white");
        listOfColors.add("black");
        listOfColors.add("blue");
        listOfColors.add("red");
        listOfColors.add("yellow");
        listOfColors.add("green");
        listOfColors.add("white");
        listOfColors.add("black");


        listAdapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, listOfColors);
        lvResult.setAdapter(listAdapter);
    }


    @Override
    protected void onStart() {
        super.onStart();
        lvResult.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3)
            {
                String content=listAdapter.getItem(position);
               Toast.makeText(getBaseContext(),content+" selected",Toast.LENGTH_LONG).show();
            }
        });
    }


}