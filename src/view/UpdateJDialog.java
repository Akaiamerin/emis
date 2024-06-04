package view;
import controller.UpdateActionListener;
import dao.impl.EmpDAOImpl;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import entity.Emp;
public class UpdateJDialog extends JDialog {
    private final JTextField idJTextField = new JTextField();
    private final JTextField nameJTextField = new JTextField();
    private final JComboBox<String> genderJComboBox = new JComboBox<>(new String[]{"男", "女"});
    private final JTextField ageJTextField = new JTextField();
    private final JComboBox<String> deptJComboBox = new JComboBox<>(new String[]{"销售部", "市场部", "技术部", "财务部", "行政部"});
    private final JComboBox<String> jobJComboBox = new JComboBox<>(new String[]{"员工", "组长", "主管", "经理", "总监"});
    private final JTextField salJTextField = new JTextField();
    public UpdateJDialog() {

    }
    public UpdateJDialog(MainJFrame mainJFrame, int empId) {
        Emp emp = new EmpDAOImpl().selectEmpById(empId);
        assert emp != null;
        //工号组件
        JLabel idLabel = new JLabel("工　号：", JLabel.RIGHT);
        idLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        idLabel.setPreferredSize(new Dimension(100, 30));
        idJTextField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        idJTextField.setPreferredSize(new Dimension(200, 30));
        idJTextField.setText(String.valueOf(emp.getId()));
        //姓名组件
        JLabel nameLabel = new JLabel("姓　名：", JLabel.RIGHT);
        nameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        nameLabel.setPreferredSize(new Dimension(100, 30));
        nameJTextField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        nameJTextField.setPreferredSize(new Dimension(200, 30));
        nameJTextField.setText(emp.getName());
        //性别组件
        JLabel genderLabel = new JLabel("性　别：", JLabel.RIGHT);
        genderLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        genderLabel.setPreferredSize(new Dimension(100, 30));
        genderJComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        genderJComboBox.setPreferredSize(new Dimension(200, 30));
        genderJComboBox.setSelectedItem(emp.getGender());
        //年龄组件
        JLabel ageLabel = new JLabel("年　龄：", JLabel.RIGHT);
        ageLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        ageLabel.setPreferredSize(new Dimension(100, 30));
        ageJTextField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        ageJTextField.setPreferredSize(new Dimension(200, 30));
        ageJTextField.setText(String.valueOf(emp.getAge()));
        //部门组件
        JLabel deptLabel = new JLabel("部　门：", JLabel.RIGHT);
        deptLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        deptLabel.setPreferredSize(new Dimension(100, 30));
        deptJComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        deptJComboBox.setPreferredSize(new Dimension(200, 30));
        deptJComboBox.setSelectedItem(emp.getDept());
        //职务组件
        JLabel jobLabel = new JLabel("职　务：", JLabel.RIGHT);
        jobLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        jobLabel.setPreferredSize(new Dimension(100, 30));
        jobJComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        jobJComboBox.setPreferredSize(new Dimension(200, 30));
        jobJComboBox.setSelectedItem(emp.getJob());
        //工资组件
        JLabel salLabel = new JLabel("工　资：", JLabel.RIGHT);
        salLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        salLabel.setPreferredSize(new Dimension(100, 30));
        salJTextField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        salJTextField.setPreferredSize(new Dimension(200, 30));
        salJTextField.setText(String.valueOf(emp.getSal()));
        //修改组件
        JButton updateJBtn = new JButton("修　改");
        updateJBtn.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        updateJBtn.addActionListener(new UpdateActionListener(mainJFrame, this));
        //JPanel设置
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        jPanel.add(idLabel);
        jPanel.add(idJTextField);
        jPanel.add(nameLabel);
        jPanel.add(nameJTextField);
        jPanel.add(genderLabel);
        jPanel.add(genderJComboBox);
        jPanel.add(ageLabel);
        jPanel.add(ageJTextField);
        jPanel.add(deptLabel);
        jPanel.add(deptJComboBox);
        jPanel.add(jobLabel);
        jPanel.add(jobJComboBox);
        jPanel.add(salLabel);
        jPanel.add(salJTextField);
        jPanel.add(updateJBtn);
        //修改信息子界面其他设置
        add(jPanel);
        setTitle("修　改");
        setModal(true);
        setSize(400, 500);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    //更新的员工信息，用于数据库
    public Emp getUpdateEmpInfo() {
        Emp emp = new Emp();
        emp.setId(Integer.valueOf(idJTextField.getText()));
        emp.setName(nameJTextField.getText());
        emp.setGender(String.valueOf(genderJComboBox.getSelectedItem()));
        emp.setAge(Integer.valueOf(ageJTextField.getText()));
        emp.setDept(String.valueOf(deptJComboBox.getSelectedItem()));
        emp.setJob(String.valueOf(jobJComboBox.getSelectedItem()));
        emp.setSal(Double.valueOf(salJTextField.getText()));
        return emp;
    }
}