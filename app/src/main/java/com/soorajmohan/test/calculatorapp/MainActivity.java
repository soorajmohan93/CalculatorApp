/*
***************************************************************
      JAV-1001 App Development for Android
      JAV1001 - MidTerm - Individual Project(Calculator App)
      Submitted by Sooraj Mohan (Student ID: A00247480)
***************************************************************
*/

package com.soorajmohan.test.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //enteredNumber contains the result of the arithmetic operations
    private float enteredNumber = 0;
    /*sign contains the arithmetic operation done
    * space means there was no arithmetic operation so copy over the value itself to enteredNumber
    * 'a' means an addition needs to be performed into the enteredNumber
    * 's' means a subtraction needs to be performed into the enteredNumber
    * 'm' means a multiplication needs to be performed into the enteredNumber
    * 'd' means a division needs to be performed into the enteredNumber*/
    private char sign = ' ';
    //inputFieldNumber will have the current value in the TextView inputField
    private String inputFieldNumber = " ";
    //operation history will capture all the operations done in the equation in operationHistoryText
    private String operationHistoryText = " ";
    //clear will specify if the inputField needs to be cleared or not
    private boolean clear = true;
    //clear history will specify if the operationHistoryText needs to be cleared or not
    private boolean clearHistory = false;
    //turnOnAdditionalFn will specify if the additional functionality buttons needs to be activated
    private boolean turnOnAdditionalFn = false;
    //turnOnNumbers will specify if the number pad needs to be activated
    private boolean turnOnNumbers = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaring all the buttons and calling setOnClickListener Event to control the functionality of each button
        Button numberOne = findViewById(R.id.numberOne);
        Button numberTwo = findViewById(R.id.numberTwo);
        Button numberThree = findViewById(R.id.numberThree);
        Button numberFour = findViewById(R.id.numberFour);
        Button numberFive = findViewById(R.id.numberFive);
        Button numberSix = findViewById(R.id.numberSix);
        Button numberSeven = findViewById(R.id.numberSeven);
        Button numberEight = findViewById(R.id.numberEight);
        Button numberNine = findViewById(R.id.numberNine);
        Button numberZero = findViewById(R.id.numberZero);
        Button decimalPoint = findViewById(R.id.numberDecimal);

        Button multiply = findViewById(R.id.multiplySign);
        Button divide = findViewById(R.id.divideSign);
        Button subtract = findViewById(R.id.minusSign);
        Button add = findViewById(R.id.addSign);
        Button equal = findViewById(R.id.equalSign);

        Button clear = findViewById(R.id.allClear);

        Button sqRoot = findViewById(R.id.sqRootSign);
        Button square = findViewById(R.id.squareSign);
        Button pi = findViewById(R.id.piSign);
        Button sin = findViewById(R.id.sinSign);
        Button cos = findViewById(R.id.cosSign);
        Button tan = findViewById(R.id.tanSign);

        numberOne.setOnClickListener(this);
        numberTwo.setOnClickListener(this);
        numberThree.setOnClickListener(this);
        numberFour.setOnClickListener(this);
        numberFive.setOnClickListener(this);
        numberSix.setOnClickListener(this);
        numberSeven.setOnClickListener(this);
        numberEight.setOnClickListener(this);
        numberNine.setOnClickListener(this);
        numberZero.setOnClickListener(this);
        decimalPoint.setOnClickListener(this);

        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        subtract.setOnClickListener(this);
        add.setOnClickListener(this);
        equal.setOnClickListener(this);

        clear.setOnClickListener(this);

        sqRoot.setOnClickListener(this);
        square.setOnClickListener(this);
        pi.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);

        //updateScreen() method is called here to update button enable/disable in initial screen
        updateScreen();


    }

    @Override
    public void onClick(View view) {

        //inputFieldNumber is filled with the value in the inputField
        TextView inputField = findViewById(R.id.inputField);
        inputFieldNumber = String.valueOf(inputField.getText());

        //check if inputField needs to be cleared? They are cleared after user chooses an arithmetic operation & equals
        if (clear)
        {
            inputFieldNumber = " ";
            clear = false;
        }

        //check if operationHistory needs to be cleared? They are cleared after equal is pressed by user
        if (clearHistory)
        {
            operationHistoryText = " ";
            clearHistory = false;
        }

        /*functionality on each button is mapped within the switch
        * number buttons will add the number to the inputField
        * decimal button will add a decimal point to the inputField, it will decimal point will be entered only once
        * Additional functions button will apply the functionality to the number entered (except pi). A number will have to be entered to activate the additional functions
        * pi button will enter pi value to the inputField, i.e. 3.14. Since it is a number button, this button is activated along with the numbers, but once a number is entered, then pi is deactivated
        * after using the special functions, the number buttons are disabled, they are enabled only after a operator button, equals or clear is pressed
        * Activation and deactivation of buttons are done to limit user from wrongly using additional functions and number keys, which can crash the application
        * The operations keys +, -, * and / will work like this - if its the first operation in the equation, it will just enter the number into the enteredNumber variable-
        * and denote the operation into the character variable "sign" as a(to add), s (to subtract), m(to multiply) and d(to divide)
        * On the subsequent operations, it will pick the previous operation in the sign variable, perform the operation between the value in enteredNumber and the new number-
        * and keeps the value in entered number. sign variable will be updated to the current operation
        * The equals sign will perform the operation as per the character in sign variable (if a new value is available in the TextView or else it would simply display result)
        * If no operations are done before equals, then the value entered is shown in the output
        * Operation History is captured using operationHistory() method for each character for numbers, decimal and operators on each button click
        * For additional functions, String values are passed into operationHistory()
        * clear button will clear all TextViews, enteredNumber and inputFieldNumber fields immediately, the clear button is disabled there is no values*/

        switch (view.getId())
        {
            //The number buttons 1 to 0
            case R.id.numberOne:
                inputFieldNumber += "1";
                operationHistory('1');
                turnOnAdditionalFn = true;
                break;
            case R.id.numberTwo:
                inputFieldNumber += "2";
                operationHistory('2');
                turnOnAdditionalFn = true;
                break;
            case R.id.numberThree:
                inputFieldNumber += "3";
                operationHistory('3');
                turnOnAdditionalFn = true;
                break;
            case R.id.numberFour:
                inputFieldNumber += "4";
                operationHistory('4');
                turnOnAdditionalFn = true;
                break;
            case R.id.numberFive:
                inputFieldNumber += "5";
                operationHistory('5');
                turnOnAdditionalFn = true;
                break;
            case R.id.numberSix:
                inputFieldNumber += "6";
                operationHistory('6');
                turnOnAdditionalFn = true;
                break;
            case R.id.numberSeven:
                inputFieldNumber += "7";
                operationHistory('7');
                turnOnAdditionalFn = true;
                break;
            case R.id.numberEight:
                inputFieldNumber += "8";
                operationHistory('8');
                turnOnAdditionalFn = true;
                break;
            case R.id.numberNine:
                inputFieldNumber += "9";
                operationHistory('9');
                turnOnAdditionalFn = true;
                break;
            case R.id.numberZero:
                inputFieldNumber += "0";
                operationHistory('0');
                turnOnAdditionalFn = true;
                break;

            //decimal button
            case R.id.numberDecimal:
                //below condition to limit decimal points to one
                if(inputFieldNumber.indexOf('.') == -1)
                {
                    inputFieldNumber += ".";
                    operationHistory('.');
                }
                break;
             //All Additional function buttons - Math methods are used to perform these functions
            case R.id.sqRootSign:
                operationHistory("√" + inputFieldNumber);
                inputFieldNumber = String.valueOf(Math.sqrt(Double.parseDouble(inputFieldNumber)));
                turnOnAdditionalFn = false;
                turnOnNumbers = false;
                break;
            case R.id.squareSign:
                operationHistory(inputFieldNumber + "\u00B2");
                inputFieldNumber = String.valueOf((Float.parseFloat(inputFieldNumber))*(Float.parseFloat(inputFieldNumber)));
                turnOnAdditionalFn = false;
                turnOnNumbers = false;
                break;
            case R.id.piSign:
                operationHistory(" \uD835\uDF0B");
                inputFieldNumber = String.valueOf(3.14f);
                turnOnAdditionalFn = true;
                turnOnNumbers = false;
                break;
            case R.id.sinSign:
                operationHistory("sin" + inputFieldNumber );
                inputFieldNumber = String.valueOf(Math.sin(Double.parseDouble(inputFieldNumber)));
                turnOnAdditionalFn = false;
                turnOnNumbers = false;
                break;
            case R.id.cosSign:
                operationHistory("cos" + inputFieldNumber );
                inputFieldNumber = String.valueOf(Math.cos(Double.parseDouble(inputFieldNumber)));
                turnOnAdditionalFn = false;
                break;
            case R.id.tanSign:
                operationHistory("tan" + inputFieldNumber );
                inputFieldNumber = String.valueOf(Math.tan(Double.parseDouble(inputFieldNumber)));
                turnOnAdditionalFn = false;
                turnOnNumbers = false;
                break;
            // allClear button resets all TextViews and Variables
            case R.id.allClear:
                enteredNumber = 0;
                inputFieldNumber = " ";
                sign = ' ';
                operationHistoryText = " ";
                turnOnAdditionalFn = false;
                turnOnNumbers = true;
                break;
            //Operator Buttons - they will do anything only if any value is entered in the inputField TextView
            case R.id.addSign:
                if (!inputFieldNumber.equals(" "))
                {
                    calculateValues(Float.parseFloat(inputFieldNumber));
                    sign = 'a';
                    clear = true;
                    operationHistory('+');
                    turnOnAdditionalFn = false;
                    turnOnNumbers = true;
                }
                break;
            case R.id.minusSign:
                if (!inputFieldNumber.equals(" "))
                {
                    calculateValues(Float.parseFloat(inputFieldNumber));
                    sign = 's';
                    clear = true;
                    operationHistory('-');
                    turnOnAdditionalFn = false;
                    turnOnNumbers = true;
                }
                break;
            case R.id.multiplySign:
                if (!inputFieldNumber.equals(" "))
                {
                    calculateValues(Float.parseFloat(inputFieldNumber));
                    sign = 'm';
                    clear = true;
                    operationHistory('×');
                    turnOnAdditionalFn = false;
                    turnOnNumbers = true;
                }
                break;
            case R.id.divideSign:
                if (!inputFieldNumber.equals(" "))
                {
                    calculateValues(Float.parseFloat(inputFieldNumber));
                    sign = 'd';
                    clear = true;
                    operationHistory('÷');
                    turnOnAdditionalFn = false;
                    turnOnNumbers = true;
                }
                break;
            // equals button, the calculation is done only if a value is entered into inputField TextView, else it would display 0 or the result until previous operation
            case R.id.equalSign:
                if (!inputFieldNumber.equals(" "))
                {
                    calculateValues(Float.parseFloat(inputFieldNumber));
                }
                operationHistory('=');
                inputFieldNumber = String.valueOf(enteredNumber);
                clear = true;
                clearHistory = true;
                sign = ' ';
                turnOnAdditionalFn = false;
                turnOnNumbers = true;
                break;
        }
        //updateScreen is called to update all the Screen elements as per the functionalities of the button
        updateScreen();
    }

    public void updateScreen()
    {
        /* clear button is active only if any value is entered into inputFieldNumber variable. It will be disabled as soon as
        user clicks a number, decimal or pi button */
        findViewById(R.id.allClear).setEnabled(!inputFieldNumber.equals(" "));

        /* to enable/disable number buttons - they are disabled once an additional function button is clicked and enabled
        soon as an operator, equals or clear button is selected*/
        findViewById(R.id.numberOne).setEnabled(turnOnNumbers);
        findViewById(R.id.numberTwo).setEnabled(turnOnNumbers);
        findViewById(R.id.numberThree).setEnabled(turnOnNumbers);
        findViewById(R.id.numberFour).setEnabled(turnOnNumbers);
        findViewById(R.id.numberFive).setEnabled(turnOnNumbers);
        findViewById(R.id.numberSix).setEnabled(turnOnNumbers);
        findViewById(R.id.numberSeven).setEnabled(turnOnNumbers);
        findViewById(R.id.numberEight).setEnabled(turnOnNumbers);
        findViewById(R.id.numberNine).setEnabled(turnOnNumbers);
        findViewById(R.id.numberZero).setEnabled(turnOnNumbers);
        findViewById(R.id.numberDecimal).setEnabled(turnOnNumbers);

        /* to enable/disable additional functions buttons, they will be available only after number keys are entered to apply function to the number entered.
        They are disabled soon after one of them are used. For pi button, its a number button hence it activated along with the number buttons,
        but disabled once the number button or any additional function button is selected */
        findViewById(R.id.sqRootSign).setEnabled(turnOnAdditionalFn);
        findViewById(R.id.squareSign).setEnabled(turnOnAdditionalFn);
        findViewById(R.id.piSign).setEnabled(!turnOnAdditionalFn);
        findViewById(R.id.sinSign).setEnabled(turnOnAdditionalFn);
        findViewById(R.id.cosSign).setEnabled(turnOnAdditionalFn);
        findViewById(R.id.tanSign).setEnabled(turnOnAdditionalFn);

        //inputField TextView to display the entered value or the result
        TextView inputField = findViewById(R.id.inputField);
        inputField.setText(inputFieldNumber);

        // operationHistory text view will display all the oeprations done in the expression
        TextView operationHistory = findViewById(R.id.operationHistory);
        operationHistory.setText(operationHistoryText);

    }

    /*All the arithmetic calculations are done within calculateValues method. It passes the new value as a parameter and perform the operation
     as per the value in sign variable. If its the first operation, then the value is directly copied into the enteredNumber variable*/
    public void calculateValues(float inputNumber)
    {
        switch (sign)
        {
            case 'a':
                enteredNumber += inputNumber;
                break;
            case 's':
                enteredNumber -= inputNumber;
                break;
            case 'm':
                enteredNumber *= inputNumber;
                break;
            case 'd':
                enteredNumber = enteredNumber/inputNumber;
                break;
            default:
                enteredNumber = inputNumber;
                break;
        }
    }

    /* operationHistory methods are used to capture all the previous entered values and operations in the expression.
    Using method overloading, there are two ways these values are captured. */

    // For numbers, decimal point, operators and equals - a character is passed in which is appended to the operationHistoryText string.
    public void operationHistory (char textInput)
    {
        int textLength = operationHistoryText.length();
        if (operationHistoryText.charAt(textLength-1) != textInput || !clear)
        operationHistoryText += textInput;
    }

    /* For additional functions, the function along with the number to which the function is applied is concatenated and passed as string.
    * Since the number which the function is applied is already available in operationHistoryText, it will have to replaced with the incoming string.
    * This is achieved using a StringBuilder and char array. All the characters from point 0 upto the point where the inputFieldNumber characters start are picked
    * and the incoming string is appended to the end to build the whole expression */
    public void operationHistory(String textInput)
    {
        //Below string replacement referred from https://stackoverflow.com/questions/14642978/replace-part-of-a-string-between-indexes-in-java
        StringBuilder buildFieldForHistory = new StringBuilder();
        char[] holdHistoryChars = operationHistoryText.toCharArray();

        buildFieldForHistory.append(holdHistoryChars , 0, operationHistoryText.length()-inputFieldNumber.length()+1).append(textInput);
        operationHistoryText = buildFieldForHistory.toString();
    }
}


