package view;
import java.util.Objects;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import utils.RandEmpInfo;
public class InitJOptionPane extends JOptionPane {
    public static void initEmpInfo(String path) {
        int opt = JOptionPane.showOptionDialog(null, "  是 否 初 始 化 员 工 信 息？", "初　始　化", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"是", "否"}, JOptionPane.CLOSED_OPTION);
        if (opt == 0) {
            while (true) {
                String initNum = JOptionPane.showInputDialog(null, "请 输 入 初 始 化 员 工 信 息 的 数 量", "初　始　化", JOptionPane.PLAIN_MESSAGE);
                if (initNum == null || Objects.equals(initNum, "") == true) {
                    continue;
                }
                else if (Pattern.compile("\\d*").matcher(initNum).matches() == true) {
                    RandEmpInfo.generateRandEmpInfo(path, Integer.parseInt(initNum));
                    break;
                }
                else {
                    JOptionPane.showMessageDialog(null, "输 入 错 误", "错　误", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}