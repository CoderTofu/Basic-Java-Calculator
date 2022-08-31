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
        return str + keyStr;
    }

    private String AddOps(String str) {
        return str + keyStr;
    }

    private String GetResult(String str) {
        return "";
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
}
