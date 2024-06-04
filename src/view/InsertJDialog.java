package view;
import controller.InsertActionListener;
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
public class InsertJDialog extends JDialog {
    private final JTextField idJTextField = new JTextField();
    private final JTextField nameJTextField = new JTextField();
    private final JComboBox<String> genderJComboBox = new JComboBox<>(new String[]{"男", "女"});
    private final JTextField ageJTextField = new JTextField();
    private final JComboBox<String> deptJComboBox = new JComboBox<>(new String[]{"销售部", "市场部", "技术部", "财务部", "行政部"});
    private final JComboBox<String> jobJComboBox = new JComboBox<>(new String[]{"员工", "组长", "主管", "经理", "总监"});
    private final JTextField salJTextField = new JTextField();
    public InsertJDialog() {

    }
    public InsertJDialog(MainJFrame mainJFrame) {
        //工号组件
        JLabel idJLabel = new JLabel("工　号：", JLabel.RIGHT);
        idJLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        idJLabel.setPreferredSize(new Dimension(100, 30));
        idJTextField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        idJTextField.setPreferredSize(new Dimension(200, 30));
        //姓名组件
        JLabel nameJLabel = new JLabel("姓　名：", JLabel.RIGHT);
        nameJLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        nameJLabel.setPreferredSize(new Dimension(100, 30));
        nameJTextField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        nameJTextField.setPreferredSize(new Dimension(200, 30));
        //性别组件
        JLabel genderJLabel = new JLabel("性　别：", JLabel.RIGHT);
        genderJLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        genderJLabel.setPreferredSize(new Dimension(100, 30));
        genderJComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        genderJComboBox.setPreferredSize(new Dimension(200, 30));
        //年龄组件
        JLabel ageJLabel = new JLabel("年　龄：", JLabel.RIGHT);
        ageJLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        ageJLabel.setPreferredSize(new Dimension(100, 30));
        ageJTextField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        ageJTextField.setPreferredSize(new Dimension(200, 30));
        //部门组件
        JLabel deptJLabel = new JLabel("部　门：", JLabel.RIGHT);
        deptJLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        deptJLabel.setPreferredSize(new Dimension(100, 30));
        deptJComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        deptJComboBox.setPreferredSize(new Dimension(200, 30));
        //组件
        JLabel jobJLabel = new JLabel("职　务：", JLabel.RIGHT);
        jobJLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        jobJLabel.setPreferredSize(new Dimension(100, 30));
        jobJComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        jobJComboBox.setPreferredSize(new Dimension(200, 30));
        //工资组件
        JLabel salJLabel = new JLabel("工　资：", JLabel.RIGHT);
        salJLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        salJLabel.setPreferredSize(new Dimension(100, 30));
        salJTextField.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        salJTextField.setPreferredSize(new Dimension(200, 30));
        //添加组件
        JButton insJBtn = new JButton("添　加");
        insJBtn.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        insJBtn.addActionListener(new InsertActionListener(mainJFrame, this));
        //JPanel设置
        JPanel jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        jPanel.add(idJLabel);
        jPanel.add(idJTextField);
        jPanel.add(nameJLabel);
        jPanel.add(nameJTextField);
        jPanel.add(genderJLabel);
        jPanel.add(genderJComboBox);
        jPanel.add(ageJLabel);
        jPanel.add(ageJTextField);
        jPanel.add(deptJLabel);
        jPanel.add(deptJComboBox);
        jPanel.add(jobJLabel);
        jPanel.add(jobJComboBox);
        jPanel.add(salJLabel);
        jPanel.add(salJTextField);
        jPanel.add(insJBtn);
        //添加信息子界面其他设置
        add(jPanel);
        setTitle("添　加");
        setModal(true);
        setSize(400, 500);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    //添加的员工信息，用于数据库
    public Emp getInsertEmpInfo() {
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