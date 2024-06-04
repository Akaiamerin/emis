package dao;
import java.util.List;
import entity.Admin;
import entity.Emp;
import view.MainJFrame;
import view.EmpInfoJTable;
public interface EmpDAO {
    String selectPwdById(Admin admin);
    boolean insertEmp(Emp emp);
    boolean updateEmpById(Emp emp);
    boolean deleteEmpById(List<Integer> selectEmpIndexList);
    Emp selectEmpById(int EmpId);
    EmpInfoJTable selectEmpByKeyword(MainJFrame mainJFrame);
}