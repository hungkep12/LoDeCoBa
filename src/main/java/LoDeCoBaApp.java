import gui.LoDeCoBaGUI;
import java.util.List;
import logic.LoDeCoBaLogic;

public class LoDeCoBaApp {

    private static final LoDeCoBaGUI gui = new LoDeCoBaGUI();

    public static void main(String[] args) {
        gui.showFrame();

        gui.addConfirmButtonListener(e -> {
            String inputText = gui.getInputText();
            if (inputText.length() != 2) {
                gui.showErrorMessage("So cua ban khac 2 chu so");
            } else {
                gui.clearTextPane();
                List<List<String>> data = LoDeCoBaLogic.generateFullPrize();
                gui.displayResult(data);
                showResult(data, inputText);
            }
        });
    }

    private static void showResult(List<List<String>> data, String input) {
        boolean hasPrized = false;
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).size(); j++) {
                hasPrized = LoDeCoBaLogic.checkHasPrize(data.get(i).get(j), input);
                if (hasPrized) {
                    break;
                }
            }
            if (hasPrized) {
                gui.showErrorMessage("Ban da trung giai " + i);
                break;
            }
        }
        if (!hasPrized) {
            gui.showErrorMessage("Rat tiec! Ban da khong trung thuong");
        }
    }

}
