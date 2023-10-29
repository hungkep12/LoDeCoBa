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
                gui.showMessage("Số của bạn khác 2 chữ số");
            } else {
                try {
                    Integer.parseInt(inputText);
                    gui.clearTextPane();
                    List<List<String>> data = LoDeCoBaLogic.generateFullPrize();
                    gui.displayResult(data);
                    showResult(data, inputText);
                }
                catch (NumberFormatException ex) {
                    gui.showMessage("Không đúng định dạng số");
                }
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
                String prize = i == 0 ? "Đặc biệt" : String.valueOf(i);
                gui.showMessage("Chúc mừng! Bạn đã trúng giải " + prize);
                break;
            }
        }
        if (!hasPrized) {
            gui.showMessage("Rất tiếc! Bạn đã không trúng thưởng");
        }
    }

}
