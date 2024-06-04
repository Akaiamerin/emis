package controller;
import dao.impl.EmpDAOImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.UpdateJDialog;
import view.MainJFrame;
public class UpdateActionListener implements ActionListener {
    private MainJFrame mainJFrame;
    private UpdateJDialog updateJDialog;
    public UpdateActionListener() {

    }
    public UpdateActionListener(MainJFrame mainJFrame, UpdateJDialog updateJDialog) {
        this.mainJFrame = mainJFrame;
        this.updateJDialog = updateJDialog;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if (new EmpDAOImpl().updateEmpById(updateJDialog.getUpdateEmpInfo()) == true) {
            mainJFrame.refreshEmpInfoTable();
            updateJDialog.dispose();
        }
        else {
            JOptionPane.showMessageDialog(updateJDialog, "修 改 失 败", "错 误", JOptionPane.ERROR_MESSAGE);
        }
    }
}