package com.example.abuosama.revvieverex3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    private   static TextView textView;

    //create a broadcast recicver


    public class  MyBroad extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent)
        {
            textView.setText("done");
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.editview1);
        button= (Button) findViewById(R.id.button1);
        textView= (TextView) findViewById(R.id.textview2);
        //link above broadvastreciver with some intent filter
        MyBroad myBroad=new MyBroad();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("work_done");
        registerReceiver(myBroad,intentFilter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //here satrt service and pass edit tex value
                String name=editText.getText().toString();
                Intent intent=new Intent(MainActivity.this,MyService.class);
                intent.putExtra("name",name);
                startService(intent);
            }
        });
    }
}
