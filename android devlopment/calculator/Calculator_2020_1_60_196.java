package edu.ewubd.calculator_v4_2020_1_60_196;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;


public class Calculator_2020_1_60_196 extends AppCompatActivity
{
    public Stack<String> left= new Stack<String>();
    public static final int STACK_LIMIT = 10;
    public Stack<String> right = new Stack<String>();
    private TextView tvEquation;
    private TextView viewOutput;
    private   int count =0;
    private  int index = 0;
    private  int index_max = 0;
    // Declare two variables to keep track of the current index of the equation stack
     // Initialize to the top equation
    /*final int MIN_EQUATION_INDEX = 0; // The minimum index is 0 (the bottom equation)
    final int[] currentEquationIndex = {count - 1};*/



    private Button btnDel, btn9, btn8, btn7, btn6, btn5, btn4, btn3, btn2, btn1, btn0, btnDiv, btnMul, btnSub, btnAdd, btnEqual, btnPoint,btnleft,btnright,btnclear;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        SharedPreferences sharedPreferences_calculator = getSharedPreferences("my_prefs", Context.MODE_PRIVATE);






        setContentView(R.layout.activity_calculator2020160196);
        tvEquation = findViewById(R.id.tvEquation);
        viewOutput = findViewById(R.id.viewOutput);
        btn9 = findViewById(R.id.btn9);
        btn8 = findViewById(R.id.btn8);
        btn7 = findViewById(R.id.btn7);
        btn6 = findViewById(R.id.btn6);
        btn5 = findViewById(R.id.btn5);
        btn4 = findViewById(R.id.btn4);
        btn3 = findViewById(R.id.btn3);
        btn2 = findViewById(R.id.btn2);
        btn1 = findViewById(R.id.btn1);
        btn0 = findViewById(R.id.btn0);
        btnDiv = findViewById(R.id.btnDiv);
        btnMul = findViewById(R.id.btnMul);
        btnSub = findViewById(R.id.btnSub);
        btnAdd = findViewById(R.id.btnAdd);
        btnDel = findViewById(R.id.btnDel);
        btnEqual = findViewById(R.id.btnEqual);
        btnPoint = findViewById(R.id.btnPoint);
        btnleft =findViewById(R.id.btnleft);
        btnright =findViewById(R.id.btnright);
        btnclear = findViewById(R.id.btnclear);

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvEquation.getText().toString();

                tvEquation.setText(text + 9);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvEquation.getText().toString();

                tvEquation.setText(text + 8);
            }
        });
        btn7.setOnClickListener(  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvEquation.getText().toString();

                tvEquation.setText(text + 7);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvEquation.getText().toString();

                tvEquation.setText(text + 6);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvEquation.getText().toString();

                tvEquation.setText(text + 5);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvEquation.getText().toString();

                tvEquation.setText(text + 4);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvEquation.getText().toString();

                tvEquation.setText(text + 3);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvEquation.getText().toString();

                tvEquation.setText(text + 2);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvEquation.getText().toString();

                tvEquation.setText(text + 1);
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvEquation.getText().toString();
                tvEquation.setText(text + 0);
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvEquation.getText().toString();
                if (text.endsWith("+")) {
                    // remove the last char
                    String newText = text.substring(0, text.length() - 1);
                    // set text with "/" at the end
                    tvEquation.setText(newText + "/");
                } else if (text.endsWith("-")) {
                    // remove the last char
                    String newText = text.substring(0, text.length() - 1);
                    // set text with "/" at the end
                    tvEquation.setText(newText + "/");
                } else if (text.endsWith("×")) {
                    // remove the last char
                    String newText = text.substring(0, text.length() - 1);
                    // set text with "/" at the end
                    tvEquation.setText(newText + "/");
                } else if (text.endsWith("/")) {
                    // do nothing
                } else {
                    // check if the last character is a dot and the user typed an operator
                    if (text.endsWith(".") && (v.getId() == R.id.btnAdd || v.getId() == R.id.btnSub || v.getId() == R.id.btnMul || v.getId() == R.id.btnDiv)) {
                        // append "0" before the operator
                        tvEquation.setText(text + "0" + getOperatorSymbol(v.getId()));
                    } else {
                        // append the operator to the end of the string
                        tvEquation.setText(text + getOperatorSymbol(v.getId()));
                    }
                }
            }

            // helper method to get the symbol of the operator based on the button id
            private String getOperatorSymbol(int id) {
                switch (id) {
                    case R.id.btnAdd:
                        return "+";
                    case R.id.btnSub:
                        return "-";
                    case R.id.btnMul:
                        return "×";
                    case R.id.btnDiv:
                        return "/";
                    default:
                        return "";
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvEquation.getText().toString();

                if (text.endsWith("+")) {
                    // remove the last char
                    String newText = text.substring(0, text.length() - 1);



                    tvEquation.setText(newText + "×");
                } else if (text.endsWith("-")) {
                    // remove the last char
                    String newText = text.substring(0, text.length() - 1);

                    tvEquation.setText(newText + "×");
                } else if (text.endsWith("/")) {
                    // remove the last char
                    String newText = text.substring(0, text.length() - 1);

                    tvEquation.setText(newText + "×");
                } else if (text.endsWith("×")) {
                    // do nothing
                }  else {
                    // check if the last character is a dot and the user typed an operator
                    if (text.endsWith(".") && (v.getId() == R.id.btnAdd || v.getId() == R.id.btnSub || v.getId() == R.id.btnMul || v.getId() == R.id.btnDiv)) {
                        // append "0" before the operator
                        tvEquation.setText(text + "0" + getOperatorSymbol(v.getId()));
                    } else {
                        // append the operator to the end of the string
                        tvEquation.setText(text + getOperatorSymbol(v.getId()));
                    }
                }
            }

            // helper method to get the symbol of the operator based on the button id
            private String getOperatorSymbol(int id) {
                switch (id) {
                    case R.id.btnAdd:
                        return "+";
                    case R.id.btnSub:
                        return "-";
                    case R.id.btnMul:
                        return "×";
                    case R.id.btnDiv:
                        return "/";
                    default:
                        return "";
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvEquation.getText().toString();
                if (text.endsWith("+")) {
                    // remove the last char
                    String newText = text.substring(0, text.length() - 1);

                    tvEquation.setText(newText + "-");
                } else if (text.endsWith("×")) {
                    // remove the last char
                    String newText = text.substring(0, text.length() - 1);

                    tvEquation.setText(newText + "-");
                } else if (text.endsWith("/")) {
                    // remove the last char
                    String newText = text.substring(0, text.length() - 1);

                    tvEquation.setText(newText + "-");
                } else if (text.endsWith("-")) {
                    // do nothing
                }  else {
                    // check if the last character is a dot and the user typed an operator
                    if (text.endsWith(".") && (v.getId() == R.id.btnAdd || v.getId() == R.id.btnSub || v.getId() == R.id.btnMul || v.getId() == R.id.btnDiv)) {
                        // append "0" before the operator
                        tvEquation.setText(text + "0" + getOperatorSymbol(v.getId()));
                    } else {
                        // append the operator to the end of the string
                        tvEquation.setText(text + getOperatorSymbol(v.getId()));
                    }
                }
            }

            // helper method to get the symbol of the operator based on the button id
            private String getOperatorSymbol(int id) {
                switch (id) {
                    case R.id.btnAdd:
                        return "+";
                    case R.id.btnSub:
                        return "-";
                    case R.id.btnMul:
                        return "×";
                    case R.id.btnDiv:
                        return "/";
                    default:
                        return "";
                }
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvEquation.getText().toString();
                if (text.endsWith("-")) {
                    // remove the last char
                    String newText = text.substring(0, text.length() - 1);

                    tvEquation.setText(newText + "+");
                } else if (text.endsWith("×")) {
                    // remove the last char
                    String newText = text.substring(0, text.length() - 1);

                    tvEquation.setText(newText + "+");
                } else if (text.endsWith("/")) {
                    // remove the last char
                    String newText = text.substring(0, text.length() - 1);

                    tvEquation.setText(newText + "+");
                } else if (text.endsWith("+")) {
                    // do nothing
                }  else {
                    // check if the last character is a dot and the user typed an operator
                    if (text.endsWith(".") && (v.getId() == R.id.btnAdd || v.getId() == R.id.btnSub || v.getId() == R.id.btnMul || v.getId() == R.id.btnDiv)) {
                        // append "0" before the operator
                        tvEquation.setText(text + "0" + getOperatorSymbol(v.getId()));
                    } else {
                        // append the operator to the end of the string
                        tvEquation.setText(text + getOperatorSymbol(v.getId()));
                    }
                }
            }

            // helper method to get the symbol of the operator based on the button id
            private String getOperatorSymbol(int id) {
                switch (id) {
                    case R.id.btnAdd:
                        return "+";
                    case R.id.btnSub:
                        return "-";
                    case R.id.btnMul:
                        return "×";
                    case R.id.btnDiv:
                        return "/";
                    default:
                        return "";
                }
            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvEquation.getText().toString();
                if (text.endsWith(".")){

                }
                else{
                    tvEquation.setText(text + ".");
                }
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = tvEquation.getText().toString();
                if (text.isEmpty()) {

                }
                else{
                    //remove one by one from the last
                    tvEquation.setText(text.substring(0, text.length() - 1));
                    // clear the output result in one click
                    viewOutput.setText("");
                }



            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnclear.setBackgroundColor(Color.rgb(68, 68, 68));

                String equation = tvEquation.getText().toString();
                if (!equation.isEmpty())
                {
                    if (count==10)
                    {
                        //re suffal
                        int te = 0;
                        for (int i= 1; i<9; i++){
                            String temp = sharedPreferences_calculator.getString("stack"+i,"");
                            SharedPreferences.Editor editor =sharedPreferences_calculator.edit();
                            editor.putString("stack"+te,temp);
                            editor.apply();
                            te++;
                        }

                    }
                    if (count==10)
                    {
                        Toast.makeText(getApplicationContext(),"Stack is full,1st equation remove",Toast.LENGTH_SHORT).show();
                        count--;
                    }

                    if (count!=10){
                            SharedPreferences.Editor editor =sharedPreferences_calculator.edit();
                            editor.putString("stack"+count, equation);
                            editor.apply();
                            count++;

                    }
                    SharedPreferences.Editor editor =sharedPreferences_calculator.edit();
                    editor.putInt("count",count);
                    editor.apply();
                    index = sharedPreferences_calculator.getInt("count",0);
                    //index--;
                    index_max = sharedPreferences_calculator.getInt("count",0);
                    //index_max--;
                }

                if (!equation.isEmpty()) {
                    try
                    {
                        // Evaluate the equation
                        double result = eval(equation);

                        // Display the result in the viewOutput view
                        //if no value after decimal then print it as intger
                        if (result % 1 == 0)
                        {
                            int result1 = (int) result;
                            viewOutput.setText(String.format("%d", result1));
                        }
                        else {
                            viewOutput.setText(String.format("%.2f", result));
                        }

                    } catch (Exception e)
                    {
                        // If the equation is invalid, display an error message
                        viewOutput.setText("Error＞﹏＜");

                    }
                }
            }
        });

        index = sharedPreferences_calculator.getInt("count",0);
        //index--;
        index_max = sharedPreferences_calculator.getInt("count",0);
        //index_max--;
       // System.out.println(index+" lll"+index_max);

        btnleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnleft.setBackgroundColor(Color.RED);
                btnright.setBackgroundColor(Color.rgb(68, 68, 68));
                if (index>=0) {
                    String equation = sharedPreferences_calculator.getString("stack" + index, "");
                    index--;

                    tvEquation.setText(equation);
                    // Evaluate the equation and display the result if it's valid
                    if(!equation.isEmpty()) {
                        try {
                            double result = eval(equation);
                            if (result % 1 == 0) {
                                int result1 = (int) result;
                                viewOutput.setText(String.format("%d", result1));
                            } else {
                                viewOutput.setText(String.format("%.2f", result));
                            }
                        } catch (Exception e) {
                            viewOutput.setText("Error＞﹏＜");
                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "No previous equation", Toast.LENGTH_SHORT).show();
                    index++;
                }
            }
        });
        btnright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnleft.setBackgroundColor(Color.rgb(68, 68, 68));
                btnright.setBackgroundColor(Color.RED);
                if (index<=index_max) {
                    String equation = sharedPreferences_calculator.getString("stack" + index, "");

                    index++;


                    tvEquation.setText(equation);
                    // Evaluate the equation and display the result if it's valid
                    if (!equation.isEmpty()) {
                        try {
                            double result = eval(equation);
                            if (result % 1 == 0) {
                                int result1 = (int) result;
                                viewOutput.setText(String.format("%d", result1));
                            } else {
                                viewOutput.setText(String.format("%.2f", result));
                            }
                        } catch (Exception e) {
                            viewOutput.setText("Error＞﹏＜");
                        }
                    }
                } else {
                    viewOutput.setText("");
                    Toast.makeText(getApplicationContext(), "No next equation", Toast.LENGTH_SHORT).show();
                    index--;
                }
            }
        });






        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences_calculator.edit();
                editor.clear();
                editor.apply();
                count = 0;
                index = 0;
                index_max = 0;
                tvEquation.setText("");
                btnclear.setBackgroundColor(Color.RED);
                btnleft.setBackgroundColor(Color.rgb(68, 68, 68));
                btnright.setBackgroundColor(Color.rgb(68, 68, 68));
                viewOutput.setText("");
                Toast.makeText(getApplicationContext(),"All value is clear",Toast.LENGTH_SHORT).show();
            }
        });


    }
    private Double eval(String equation)
    {
        String input = equation;


        String[] parts = input.split("(?<=\\d)(?=[+\\-×/])|(?<=[+\\-×/])(?=\\d)");

        // Initialize the result to the first operand
        double result = Double.parseDouble(parts[0]);


        // Perform the calculation for each operator and operand
        for (int i = 1; i < parts.length; i += 2) {
            char operator = parts[i].charAt(0);
            double operand = Double.parseDouble(parts[i + 1]);
            if (operator == '/' && operand == 0) {
                Toast.makeText(getApplicationContext(), "Can't divide by zero", Toast.LENGTH_SHORT).show();
                result = Double.NaN; // set the result to undifiend
                break;
            }


            switch (operator) {
                case '+':
                    result += operand;
                    break;
                case '-':
                    result -= operand;
                    break;
                case '×':
                    result *= operand;
                    break;
                case '/':
                    result /= operand;
                    break;


            }
        }

        // Output the result
        return result;
    }


}
