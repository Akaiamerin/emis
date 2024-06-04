package utils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import entity.Emp;
public class RandEmpInfo {
    private static final ArrayList<String> GENDER_ARR_LIST = new ArrayList<>(Arrays.asList("男", "女"));
    private static final ArrayList<String> DEPT_ARR_LIST = new ArrayList<>(Arrays.asList("销售部", "市场部", "技术部", "财务部", "行政部"));
    private static final ArrayList<String> JOB_ARR_LIST = new ArrayList<>(Arrays.asList("员工", "组长", "主管", "经理", "总监"));
    private static String generateOneRandEmpInfo() {
        SecureRandom secRand = new SecureRandom();
        Emp emp = new Emp();
        emp.setId(20220000 + secRand.nextInt(9999));
        emp.setName(String.valueOf(new StringBuilder().append((char) ('A' + secRand.nextInt('Z' - 'A'))).append((char) ('a' + secRand.nextInt('z' - 'a'))).append((char) ('a' + secRand.nextInt('z' - 'a')))));
        emp.setGender(GENDER_ARR_LIST.get(secRand.nextInt(2)));
        emp.setAge(18 + secRand.nextInt(42));
        emp.setDept(DEPT_ARR_LIST.get(secRand.nextInt(DEPT_ARR_LIST.size())));
        emp.setJob(JOB_ARR_LIST.get(secRand.nextInt(JOB_ARR_LIST.size())));
        for (int i = 0; i < JOB_ARR_LIST.size(); i++) {
            if (Objects.equals(JOB_ARR_LIST.get(i), emp.getJob()) == true) {
                emp.setSal(Double.valueOf(String.format("%.2f", 3000 + (200 * i) + secRand.nextDouble(200))));
            }
        }
        StringBuilder ret = new StringBuilder("INSERT INTO emp (id, name, gender, age, dept, job, sal) VALUES (").append(emp.getId()).append(", '").append(emp.getName()).append("', '").append(emp.getGender()).append("', ").append(emp.getAge()).append(", '").append(emp.getDept()).append("', '").append(emp.getJob()).append("', ").append(emp.getSal()).append(");");
        return String.valueOf(ret);
    }
    public static void generateRandEmpInfo(String path, int randEmpInfoNum) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path));
            for (int i = 0; i < randEmpInfoNum; i++) {
                String oneRandEmpInfo = generateOneRandEmpInfo();
                Connection conn = null;
                PreparedStatement prepStmt = null;
                try {
                    conn = JDBCUtils.getConn();
                    assert conn != null;
                    prepStmt = conn.prepareStatement(oneRandEmpInfo);
                    prepStmt.executeUpdate();
                }
                catch (SQLException exc) {
                    exc.printStackTrace();
                }
                finally {
                    JDBCUtils.closePrepStmt(prepStmt);
                    JDBCUtils.closeConn(conn);
                }
                bw.write(oneRandEmpInfo);
                bw.newLine();
                bw.flush();
            }
        }
        catch (IOException exc) {
            exc.printStackTrace();
        }
        finally {
            if (bw != null) {
                try {
                    bw.close();
                }
                catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        }
    }
}