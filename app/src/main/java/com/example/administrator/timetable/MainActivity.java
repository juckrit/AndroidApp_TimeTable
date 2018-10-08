package com.example.administrator.timetable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ListView listView;
    public void generate(int progress){
        ArrayList<String> myArrayList= new ArrayList<>();
        for (int i =1;i<=10;i++){
            myArrayList.add(Integer.toString(i*progress));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,myArrayList);
        listView.setAdapter(arrayAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        listView = (ListView)findViewById(R.id.listview);
        seekBar.setMax(20);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int seekbarInt;
                if (progress<min){
                    seekbarInt = 1;
                    seekBar.setProgress(1);
                }else {
                    seekbarInt = progress;
                }
                Log.i("Seekbarrrrrrrrrrrrrrrrrrrrr",Integer.toString(seekbarInt));
               generate(seekbarInt);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
