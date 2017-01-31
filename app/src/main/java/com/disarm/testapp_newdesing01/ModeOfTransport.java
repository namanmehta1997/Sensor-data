package com.disarm.testapp_newdesing01;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by ajalan on 20/12/16.
 */

public class ModeOfTransport extends Activity{
    private Button submit;
    private RadioGroup rg;
    private RadioButton radio;
    public static String mode="";
    private TextView show;
    private EditText other_mode;
    private String appFolderName="GPSAndSensorRecorder", timestampStr;
    private File folder, subfolder;
    private Date date;
    private Long time;
    private Timestamp timestamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_of_transport);
        submit = (Button) findViewById(R.id.button);
        rg = (RadioGroup) findViewById(R.id.radio_group);
        show=(TextView) findViewById(R.id.transport);
        show.setText("Select a mode of transport:");
        other_mode = (EditText) findViewById(R.id.editText);
        other_mode.setEnabled(false);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton others = (RadioButton) findViewById(R.id.rb_others);
                RadioButton checked= (RadioButton) findViewById(checkedId);
                if(others == checked){
                    other_mode.setEnabled(true);
                }
            }
        });


        OnSubmitClick();
    }
    public void OnSubmitClick() {
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected_id = rg.getCheckedRadioButtonId();
                radio = (RadioButton) findViewById(selected_id);
                RadioButton others = (RadioButton) findViewById(R.id.rb_others);
                if(radio==others){
                    mode=other_mode.getText().toString();
                    other_mode.setEnabled(false);
                    other_mode.setText("");
                }else {
                    mode = radio.getText().toString();
                }
                Intent intent = new Intent(ModeOfTransport.this, MainActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }

    public static String getMode(){
        return mode;
    }
}
