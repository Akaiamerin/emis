package controller;
import dao.impl.EmpDAOImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.InsertJDialog;
import view.MainJFrame;
public class InsertActionListener implements ActionListener {
    private MainJFrame mainJFrame;
    private InsertJDialog insertJDialog;
    public InsertActionListener() {

    }
    public InsertActionListener(MainJFrame mainJFrame, InsertJDialog insertJDialog) {
        this.insertJDialog = insertJDialog;
        this.mainJFrame = mainJFrame;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if (new EmpDAOImpl().insertEmp(insertJDialog.getInsertEmpInfo()) == true) {
            mainJFrame.refreshEmpInfoTable();
            insertJDialog.dispose();
        }
        else {
            JOptionPane.showMessageDialog(insertJDialog, "添 加 失 败", "错　误", JOptionPane.ERROR_MESSAGE);
        }
    }
}