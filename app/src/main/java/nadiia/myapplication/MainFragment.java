package nadiia.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class MainFragment extends Fragment {

    TextView textView;
    TextView textViewResult;

    public MainFragment() { }

    public static MainFragment newInstance() { return new MainFragment(); }

    @Override public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        textView = (TextView) view.findViewById(R.id.textView1);
        textViewResult = (TextView) view.findViewById(R.id.textViewResult);

        Button button1 = (Button) view.findViewById(R.id.button1);
        button1.setOnClickListener(buttonClick);
        Button button2 = (Button) view.findViewById(R.id.button2);
        button2.setOnClickListener(buttonClick);
        Button button3 = (Button) view.findViewById(R.id.button3);
        button3.setOnClickListener(buttonClick);
        Button button4 = (Button) view.findViewById(R.id.button4);
        button4.setOnClickListener(buttonClick);
        Button button5 = (Button) view.findViewById(R.id.button5);
        button5.setOnClickListener(buttonClick);
        Button button6 = (Button) view.findViewById(R.id.button6);
        button6.setOnClickListener(buttonClick);
        Button button7 = (Button) view.findViewById(R.id.button7);
        button7.setOnClickListener(buttonClick);
        Button button8 = (Button) view.findViewById(R.id.button8);
        button8.setOnClickListener(buttonClick);
        Button button9 = (Button) view.findViewById(R.id.button9);
        button9.setOnClickListener(buttonClick);
        Button button0 = (Button) view.findViewById(R.id.button0);
        button0.setOnClickListener(buttonClick);

        Button buttonDot = (Button) view.findViewById(R.id.buttonDot);
        buttonDot.setOnClickListener(buttonClick);

        Button buttonMult = (Button) view.findViewById(R.id.buttonX);
        buttonMult.setOnClickListener(buttonClick);
        Button buttonDel = (Button) view.findViewById(R.id.buttonDel);
        buttonDel.setOnClickListener(buttonClick);
        Button buttonMinus = (Button) view.findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(buttonClick);
        Button buttonPlus = (Button) view.findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(buttonClick);

        Button buttonClear = (Button) view.findViewById(R.id.buttonBack);
        buttonClear.setOnClickListener(buttonClick);
        buttonClear.setLongClickable(true);
        buttonClear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                textView.setText("");
                return false;
            }
        });

        Button buttonBrackets = (Button) view.findViewById(R.id.buttonBrackets);
        buttonBrackets.setOnClickListener(buttonClick);
        return view;
    }

    View.OnClickListener buttonClick = new View.OnClickListener() {
        @Override public void onClick(View v) {
            switch (v.getId()){
                case R.id.button1: textView.setText(textView.getText() + "1"); break;
                case R.id.button2: textView.setText(textView.getText() + "2"); break;
                case R.id.button3: textView.setText(textView.getText() + "3"); break;
                case R.id.button4: textView.setText(textView.getText() + "4"); break;
                case R.id.button5: textView.setText(textView.getText() + "5"); break;
                case R.id.button6: textView.setText(textView.getText() + "6"); break;
                case R.id.button7: textView.setText(textView.getText() + "7"); break;
                case R.id.button8: textView.setText(textView.getText() + "8"); break;
                case R.id.button9: textView.setText(textView.getText() + "9"); break;
                case R.id.button0: textView.setText(textView.getText() + "0"); break;

                case R.id.buttonDot:
                    if(textView.getText() != "" &&
                            textView.getText().charAt(textView.getText().length()-1) != '/' &&
                            textView.getText().charAt(textView.getText().length()-1) != '*' &&
                            textView.getText().charAt(textView.getText().length()-1) != '(' &&
                            textView.getText().charAt(textView.getText().length()-1) != ')' &&
                            textView.getText().charAt(textView.getText().length()-1) != '-' &&
                            textView.getText().charAt(textView.getText().length()-1) != '+' &&
                            textView.getText().charAt(textView.getText().length()-1) != '.') {
                        textView.setText(textView.getText() + ".");
                    }
                    break;
                case R.id.buttonBack:
                    if(textView.getText().length() > 0) {
                        textView.setText(textView.getText().subSequence(0, textView.getText().length() - 1));
                    }
                    break;
                case R.id.buttonDel:
                    if(textView.getText() != "" &&
                            textView.getText().charAt(textView.getText().length()-1) != '.' &&
                            textView.getText().charAt(textView.getText().length()-1) != '(') {
                        if (textView.getText().charAt(textView.getText().length() - 1) != '/' &&
                                textView.getText().charAt(textView.getText().length() - 1) != '*' &&
                                textView.getText().charAt(textView.getText().length() - 1) != '-' &&
                                textView.getText().charAt(textView.getText().length() - 1) != '+') {
                            textView.setText(textView.getText() + "/");
                        } else {
                            textView.setText(textView.getText().subSequence(0, textView.getText().length() - 1) + "/");
                        }
                    }
                    break;
                case R.id.buttonMinus:
                    if(textView.getText() != "" && textView.getText().charAt(textView.getText().length()-1) != '.' &&
                            textView.getText().charAt(textView.getText().length()-1) != '(') {
                        if (textView.getText().charAt(textView.getText().length() - 1) != '/' &&
                                textView.getText().charAt(textView.getText().length() - 1) != '*' &&
                                textView.getText().charAt(textView.getText().length() - 1) != '-' &&
                                textView.getText().charAt(textView.getText().length() - 1) != '+') {
                            textView.setText(textView.getText() + "-");
                        } else {
                            textView.setText(textView.getText().subSequence(0, textView.getText().length() - 1) + "-");
                        }
                    }
                    break;
                case R.id.buttonX:
                    if(textView.getText() != "" && textView.getText().charAt(textView.getText().length()-1) != '.' &&
                            textView.getText().charAt(textView.getText().length()-1) != '(') {
                        if (textView.getText().charAt(textView.getText().length() - 1) != '/' &&
                                textView.getText().charAt(textView.getText().length() - 1) != '*' &&
                                textView.getText().charAt(textView.getText().length() - 1) != '-' &&
                                textView.getText().charAt(textView.getText().length() - 1) != '+') {
                            textView.setText(textView.getText() + "*");
                        } else {
                            textView.setText(textView.getText().subSequence(0, textView.getText().length() - 1) + "*");
                        }
                    }
                    break;
                case R.id.buttonPlus:
                    if(textView.getText() != "" && textView.getText().charAt(textView.getText().length()-1) != '.' &&
                            textView.getText().charAt(textView.getText().length()-1) != '(') {
                        if (textView.getText().charAt(textView.getText().length() - 1) != '/' &&
                                textView.getText().charAt(textView.getText().length() - 1) != '*' &&
                                textView.getText().charAt(textView.getText().length() - 1) != '-' &&
                                textView.getText().charAt(textView.getText().length() - 1) != '+') {
                            textView.setText(textView.getText() + "+");
                        } else {
                            textView.setText(textView.getText().subSequence(0, textView.getText().length() - 1) + "+");
                        }
                    }
                    break;
                case R.id.buttonBrackets:
                    if(textView.getText() == ""){
                        textView.setText(textView.getText() + "(");
                    } else if ( textView.getText().charAt(textView.length()-1) == '+' ||
                            textView.getText().charAt(textView.length()-1) == '-' ||
                            textView.getText().charAt(textView.length()-1) == '/' ||
                            textView.getText().charAt(textView.length()-1) == '*' ||
                            textView.getText().charAt(textView.length()-1) == '('){
                        textView.setText(textView.getText() + "(");
                    } else if ( Character.isDigit( textView.getText().charAt(textView.length()-1)) ||
                            textView.getText().charAt(textView.length()-1) == ')') {
                        if(textView.getText().toString().contains("("))
                            textView.setText(textView.getText() + ")");
                    }
                    break;
                default: break;
            }
            result();
        }
    };

    void result(){
        String str = textView.getText().toString();
        if(str.length() == 0) {
            textViewResult.setText("");
        } else if (Character.isDigit(textView.getText().charAt(textView.length()-1))){
            try {
                double result = solve(str);
                DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
                otherSymbols.setDecimalSeparator('.');
                NumberFormat nf = new DecimalFormat("##.######", otherSymbols);

                textViewResult.setText(nf.format(result));
            } catch (Exception e) { textViewResult.setText(""); }
        }
    }

    double solve(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    switch (func) {
                        case "sqrt": x = Math.sqrt(x); break;
                        case "sin": x = Math.sin(Math.toRadians(x)); break;
                        case "cos": x = Math.cos(Math.toRadians(x)); break;
                        case "tan": x = Math.tan(Math.toRadians(x)); break;
                        default: throw new RuntimeException("Unknown function: " + func);
                    }
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation
                return x;
            }
        }.parse();
    }

    @Override public void onAttach(Context context) {
        super.onAttach(context);
    }
    @Override public void onDetach() {
        super.onDetach();
    }
}
