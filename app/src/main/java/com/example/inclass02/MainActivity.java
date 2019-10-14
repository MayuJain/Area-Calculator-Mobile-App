package com.example.inclass02;

/*
* Assignment 02
* MainActivity.java
* Team: Mayuri Jain, Narendra Pahuja
*/

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_shape;
    private TextView tv_result;
    private Button button_calculate;
    private Button button_clear;
    private ImageView iv_triangle;
    private ImageView iv_square;
    private ImageView iv_circle;
    private EditText et_length1;
    private EditText et_length2;
    private String selectedShape;
    double length1 = 0.0;
    double length2 = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // setTitle("Area Calculator");

        et_length1 = findViewById(R.id.et_length1);
        et_length2 = findViewById(R.id.et_length2);
        tv_result = findViewById(R.id.tv_result);
        tv_shape = findViewById(R.id.tv_figure);
        button_calculate = findViewById(R.id.bt_calculate);
        button_clear = findViewById(R.id.bt_clear);
        iv_square = findViewById(R.id.im_square);
        iv_circle = findViewById(R.id.im_circle);
        iv_triangle = findViewById(R.id.im_triangle);

        clearButton();

       button_clear.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               clearButton();
           }
       });

       iv_triangle.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String shapeSel = getResources().getString(R.string.triangleText);
               selectedShape = shapeSel;
               tv_shape.setText(shapeSel);
               et_length1.setVisibility(View.VISIBLE);
               et_length2.setVisibility(View.VISIBLE);
           }
       });

        iv_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shapeSel = getResources().getString(R.string.circleText);
                selectedShape = shapeSel;
                tv_shape.setText(shapeSel);
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.INVISIBLE);
            }
        });

        iv_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String shapeSel = getResources().getString(R.string.squareText);
                selectedShape = shapeSel;
                tv_shape.setText(shapeSel);
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.INVISIBLE);
            }
        });

       button_calculate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               String tempLength1 = et_length1.getText().toString();
               String tempLength2 = et_length2.getText().toString();

               if(tempLength1.equals("")){
                   et_length1.setError(getResources().getString(R.string.error));
               }

               if(tempLength2.equals("")){
                   et_length2.setError(getResources().getString(R.string.error));
               }

               if(tempLength1 != null && !tempLength1.equals("")){
                   length1 = Double.parseDouble(et_length1.getText().toString());
               }
               if(tempLength2 != null && !tempLength2.equals("")){
                   length2 = Double.parseDouble(et_length2.getText().toString());
               }

               if(selectedShape == getResources().getString(R.string.triangleText)){
                double result = 0.5 * length1 * length2;
                tv_result.setText(String.valueOf(result));
               }else if (selectedShape == getResources().getString(R.string.circleText)){
                   double result = 3.1416 * length1 * length1;
                   tv_result.setText(String.valueOf(result));
               }else if(selectedShape == getResources().getString(R.string.squareText)){
                   double result = length1 * length1;
                   tv_result.setText(String.valueOf(result));
               }
           }
       });

    }

    public void clearButton(){
        et_length1.setVisibility(View.VISIBLE);
        et_length1.setError(null);
        et_length2.setVisibility(View.VISIBLE);
        et_length2.setError(null);
        et_length1.setText("");
        et_length2.setText("");
        tv_shape.setText(getResources().getString(R.string.select_a_shape));
        tv_result.setText("");
        selectedShape = "none";

    }
}
