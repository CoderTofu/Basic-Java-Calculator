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
            keyType = "operation";
        }
    }

    public void main() {
        String curString = displayPanel.calcDisplay.getText();
        String newString = switch (keyType) {
            case "number" -> AddNums(curString);
            case "operation" -> AddOps(curString);
            case "=" -> GetResult(curString);
            default -> "";
        };
        displayPanel.calcDisplay.setText(newString);
    }

    private String AddNums(String str) {
        return str + keyStr;
    }

    private String AddOps(String str) {
        return str + keyStr;
    }

    private String GetResult(String str) {
        return str + keyStr;
    }
}
