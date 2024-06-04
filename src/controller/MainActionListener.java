package controller;
import dao.impl.EmpDAOImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import view.InsertJDialog;
import view.UpdateJDialog;
import view.LoginJFrame;
import view.MainJFrame;
public class MainActionListener implements ActionListener {
    private MainJFrame mainJFrame;
    public MainActionListener() {

    }
    public MainActionListener(MainJFrame mainJFrame) {
        this.mainJFrame = mainJFrame;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        JButton jBtn = (JButton) (event.getSource());
        if (Objects.equals(jBtn.getText(), "添　加") == true) {
            new InsertJDialog(mainJFrame);
        }
        else if (Objects.equals(jBtn.getText(), "修　改") == true) {
            List<Integer> selectEmpIndexList = mainJFrame.getSelectIndexList(); //获取选择的员工信息数量
            if (selectEmpIndexList.size() == 0) {
                JOptionPane.showMessageDialog(mainJFrame, "请 选 择 要 修 改 的 信 息", "错　误", JOptionPane.ERROR_MESSAGE);
            }
            else if (selectEmpIndexList.size() > 1) {
                JOptionPane.showMessageDialog(mainJFrame, "一 次 只 能 修 改 一 条 信 息", "错　误", JOptionPane.ERROR_MESSAGE);
            }
            else {
                new UpdateJDialog(mainJFrame, selectEmpIndexList.get(0));
            }
        }
        else if (Objects.equals(jBtn.getText(), "删　除") == true) {
            List<Integer> selectEmpIndexList = mainJFrame.getSelectIndexList(); //获取选择的员工信息数量
            if (selectEmpIndexList.size() == 0) {
                JOptionPane.showMessageDialog(mainJFrame, "请 选 择 要 删 除 的 信 息", "错　误", JOptionPane.ERROR_MESSAGE);
            }
            else {
                int opt = JOptionPane.showConfirmDialog(mainJFrame, "确 定 要 删 除 选 择 的 " + selectEmpIndexList.size() + " 条 信 息 吗？", "删　除", JOptionPane.YES_NO_OPTION);
                if (opt == JOptionPane.YES_OPTION) {
                    if (new EmpDAOImpl().deleteEmpById(selectEmpIndexList) == true) {
                        mainJFrame.refreshEmpInfoTable();
                    }
                    else {
                        JOptionPane.showMessageDialog(mainJFrame, "删 除 失 败", "错　误", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        else if (Objects.equals(jBtn.getText(), "查　询") == true) {
            mainJFrame.refreshEmpInfoTable();
        }
        else if (Objects.equals(jBtn.getText(), "返回登录界面") == true) {
            mainJFrame.dispose();
            new LoginJFrame();
        }
    }
}