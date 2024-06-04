package view;
import controller.LoginActionListener;
import dao.impl.EmpDAOImpl;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import entity.Admin;
public class LoginJFrame extends JFrame {
    private final JTextField acctJTextField = new JTextField();
    private final JPasswordField passwordJPasswordField = new JPasswordField();
    public LoginJFrame() {
        SpringLayout springLayout = new SpringLayout();
        JPanel jPanel = new JPanel(springLayout);
        //员 工 信 息 管 理 系 统
        JLabel titleJLabel = new JLabel("员 工 信 息 管 理 系 统", JLabel.CENTER);
        titleJLabel.setFont(new Font("微软雅黑", Font.BOLD, 50));
        springLayout.putConstraint(SpringLayout.WEST, titleJLabel, 140, SpringLayout.WEST, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, titleJLabel, 100, SpringLayout.NORTH, jPanel);
        //账号组件
        JLabel acctJLabel = new JLabel("账　号:", JLabel.CENTER);
        acctJLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        acctJTextField.setPreferredSize(new Dimension(200, 30));
        springLayout.putConstraint(SpringLayout.WEST, acctJLabel, 250, SpringLayout.WEST, jPanel);
        springLayout.putConstraint(SpringLayout.NORTH, acctJLabel, 250, SpringLayout.NORTH, jPanel);
        springLayout.putConstraint(SpringLayout.WEST, acctJTextField, 20, SpringLayout.EAST, acctJLabel);
        springLayout.putConstraint(SpringLayout.NORTH, acctJTextField, 0, SpringLayout.NORTH, acctJLabel);
        //密码组件
        JLabel passwordJLabel = new JLabel("密　码:", JLabel.CENTER);
        passwordJLabel.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        passwordJPasswordField.setPreferredSize(new Dimension(200, 30));
        springLayout.putConstraint(SpringLayout.WEST, passwordJLabel, 0, SpringLayout.WEST, acctJLabel);
        springLayout.putConstraint(SpringLayout.NORTH, passwordJLabel, 20, SpringLayout.SOUTH, acctJLabel);
        springLayout.putConstraint(SpringLayout.WEST, passwordJPasswordField, 20, SpringLayout.EAST, passwordJLabel);
        springLayout.putConstraint(SpringLayout.NORTH, passwordJPasswordField, 0, SpringLayout.NORTH, passwordJLabel);
        //登录组件
        JButton loginJButton = new JButton("登　录");
        loginJButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        springLayout.putConstraint(SpringLayout.WEST, loginJButton, 0, SpringLayout.WEST, passwordJLabel);
        springLayout.putConstraint(SpringLayout.NORTH, loginJButton, 40, SpringLayout.NORTH, passwordJLabel);
        loginJButton.addActionListener(new LoginActionListener(this));
        getRootPane().setDefaultButton(loginJButton); //回车登录
        //退出组件
        JButton exitJButton = new JButton("退　出");
        exitJButton.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        springLayout.putConstraint(SpringLayout.WEST, exitJButton, 100, SpringLayout.WEST, passwordJPasswordField);
        springLayout.putConstraint(SpringLayout.NORTH, exitJButton, 40, SpringLayout.NORTH, passwordJPasswordField);
        exitJButton.addActionListener(new LoginActionListener(this));
        //JPanel设置
        jPanel.add(titleJLabel);
        jPanel.add(acctJLabel);
        jPanel.add(acctJTextField);
        jPanel.add(passwordJLabel);
        jPanel.add(passwordJPasswordField);
        jPanel.add(loginJButton);
        jPanel.add(exitJButton);
        //登录界面其他设置
        add(jPanel);
        setTitle("员 工 信 息 管 理 系 统");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void login() {
        String acct = acctJTextField.getText();
        String pwd = String.valueOf(passwordJPasswordField.getPassword()); //返回值类型为 char[]
        if (Objects.equals(pwd, new EmpDAOImpl().selectPwdById(new Admin(acct, pwd))) == true) {
            dispose();
            new MainJFrame();
        }
        else {
            JOptionPane.showMessageDialog(this, "       账 号 或 密 码 错 误", "错　误", JOptionPane.ERROR_MESSAGE);
        }
    }
}