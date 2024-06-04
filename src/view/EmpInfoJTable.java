package view;
import java.awt.Font;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
public class EmpInfoJTable extends JTable {
    private Vector<Vector<Object>> empInfoJTable; //员工信息表格
    public EmpInfoJTable() {
        setFont(new Font("微软雅黑", Font.PLAIN, 20));
        setRowHeight(30);
        setAutoCreateRowSorter(true); //排序
        setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); //多行选择
        DefaultTableCellRenderer defaultTableCellRenderer = new DefaultTableCellRenderer();
        defaultTableCellRenderer.setHorizontalAlignment(JLabel.CENTER);
        setDefaultRenderer(Object.class, defaultTableCellRenderer); //居中对齐
    }
    public Vector<Vector<Object>> getEmpInfoJTable() {
        return empInfoJTable;
    }
    public void setEmpInfoJTable(Vector<Vector<Object>> empInfoJTable) {
        this.empInfoJTable = empInfoJTable;
    }
}