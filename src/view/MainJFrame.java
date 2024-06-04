package view;
import controller.MainActionListener;
import dao.impl.EmpDAOImpl;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
public class MainJFrame extends JFrame {
    private String keyword; //查询关键词
    private final JTextField queryJTextField = new JTextField(15);
    private final EmpInfoJTable empInfoJTable = new EmpInfoJTable();
    public MainJFrame() {
        MainActionListener mainActionListener = new MainActionListener(this);
        //添加组件
        JButton insertJBtn = new JButton("添　加");
        insertJBtn.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        insertJBtn.addActionListener(mainActionListener);
        //修改组件
        JButton updateJBtn = new JButton("修　改");
        updateJBtn.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        updateJBtn.addActionListener(mainActionListener);
        //删除组件
        JButton deleteJBtn = new JButton("删　除");
        deleteJBtn.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        deleteJBtn.addActionListener(mainActionListener);
        //查询组件
        queryJTextField.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        JButton queryJBtn = new JButton("查　询");
        queryJBtn.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        queryJBtn.addActionListener(mainActionListener);
        //返回登录界面组件
        JButton reLoginJBtn = new JButton("返回登录界面");
        reLoginJBtn.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        reLoginJBtn.addActionListener(mainActionListener);
        EmpInfoJTable empInfoJTableObj = getEmpJTableObj();
        empInfoJTable.setModel(EmpInfoDefaultTableModel.initEmpDefTableModel(empInfoJTableObj.getEmpInfoJTable())); //初始化
        //JPanel设置
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jPanel.add(insertJBtn);
        jPanel.add(updateJBtn);
        jPanel.add(deleteJBtn);
        jPanel.add(queryJTextField);
        jPanel.add(queryJBtn);
        jPanel.add(reLoginJBtn);
        //主界面其他设置
        add(jPanel, BorderLayout.NORTH);
        add(new JScrollPane(empInfoJTable), BorderLayout.CENTER); //可滑动
        setTitle("员 工 信 息 管 理 系 统");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public String getKeyword() {
        return keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    //获取主界面的表格信息初始化表格模型
    public EmpInfoJTable getEmpJTableObj() {
        setKeyword(queryJTextField.getText().trim());
        return new EmpDAOImpl().selectEmpByKeyword(this);
    }
    //刷新表格模型
    public void refreshEmpInfoTable() {
        EmpInfoDefaultTableModel.refreshEmpDefTableModel(getEmpJTableObj().getEmpInfoJTable());
    }
    //选择员工信息的行数
    public List<Integer> getSelectIndexList() {
        List<Integer> selectIndexList = new ArrayList<>();
        for (int i = 0; i < empInfoJTable.getSelectedRows().length; i++) {
            int rowIndex = empInfoJTable.getSelectedRows()[i];
            selectIndexList.add(Integer.parseInt(String.valueOf(empInfoJTable.getValueAt(rowIndex, 0))));
        }
        return selectIndexList;
    }
}