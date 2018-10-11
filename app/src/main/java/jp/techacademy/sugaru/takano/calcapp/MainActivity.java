package jp.techacademy.sugaru.takano.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText mEditText1;
    EditText mEditText2;

    double value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button)findViewById(R.id.button4);
        button4.setOnClickListener(this);

        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(this,SecondActivity.class);

        try {
            String str1 = mEditText1.getText().toString();
            String str2 = mEditText2.getText().toString();

            double number1 = Double.parseDouble(str1);
            double number2 = Double.parseDouble(str2);



            if (v.getId() == R.id.button1) {
                value = number1 + number2;
            } else if (v.getId() == R.id.button2) {
                value = number1 - number2;
            } else if (v.getId() == R.id.button3) {
                value = number1 * number2;
            } else if (v.getId() == R.id.button4) {
                value = number1 / number2;
            }


            intent.putExtra("VALUE",value);
            startActivity(intent);
        }catch (Exception e) {
            Log.d("javatest", e.getMessage());
        }
    }
}
