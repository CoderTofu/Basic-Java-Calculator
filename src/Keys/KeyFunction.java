package Keys;

import Panels.DisplayPanel;

public class KeyFunction {
    public String keyType;
    private final String keyStr;
    private final DisplayPanel displayPanel;
    public KeyFunction(String keyString, DisplayPanel display) {
        displayPanel = display;
        keyStr = keyString;
        try {
            Integer.parseInt(keyString);
            keyType = "number";
        } catch (NumberFormatException e) {
            if (keyString.equals("Del")) {
                keyType = "Del";
            } else if (keyString.equals("Clear")) {
                keyType = "Clear";
            } else {
                keyType = "operation";
            }
        }
    }

    public void main() {
        String curString = displayPanel.calcDisplay.getText();
        String newString = null;

        switch (keyType) {
            case "number" -> newString = AddNums(curString);
            case "operation" -> {
                if (keyStr.equals("=")) {
                    newString = GetResult(curString);
                } else {
                    newString = AddOps(curString);
                }
            }
            case "Del" -> newString = Delete(curString);
            case "Clear" -> newString = Clear();
        }
        displayPanel.calcDisplay.setText(newString);
    }

    private String AddNums(String str) {
        if (str.equals("Error")) {
            return keyStr;
        }
        return str + keyStr;
    }

    private String AddOps(String str) {
        if (str.equals("Error")) {
            return keyStr;
        }
        return str + keyStr;
    }

    private String GetResult(String str) {
        try {
            return  String.valueOf(eval(str));
        } catch (Exception e) {
            return "Error";
        }
    }

    private String Delete(String str) {
        if (str.length() <= 1) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder(str);
            sb.deleteCharAt(str.length() -1);
            return sb.toString();
        }
    }

    private String Clear() {
        return "";
    }

    // This function was brought to you by:
    // https://stackoverflow.com/questions/3422673/how-to-evaluate-a-math-expression-given-in-string-form?noredirect=1&lq=1
    // Second most upvoted answer, by Boann Oct 7, 2014
    public static double eval(final String str) {
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
            // factor = `+` factor | `-` factor | `(` expression `)` | number
            //        | functionName `(` expression `)` | functionName factor
            //        | factor `^` factor

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
                if (eat('+')) return +parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    if (!eat(')')) throw new RuntimeException("Missing ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    if (eat('(')) {
                        x = parseExpression();
                        if (!eat(')')) throw new RuntimeException("Missing ')' after argument to " + func);
                    } else {
                        x = parseFactor();
                    }
                    x = switch (func) {
                        case "sqrt" -> Math.sqrt(x);
                        case "sin" -> Math.sin(Math.toRadians(x));
                        case "cos" -> Math.cos(Math.toRadians(x));
                        case "tan" -> Math.tan(Math.toRadians(x));
                        default -> throw new RuntimeException("Unknown function: " + func);
                    };
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}
