import view.LoginJFrame;
import view.InitJOptionPane;
public class EntEmpInfoMgmtSys {
    public static void main(String[] args) {
        InitJOptionPane.initEmpInfo("./src/resrc/emp.sql");
        new LoginJFrame();
    }
}