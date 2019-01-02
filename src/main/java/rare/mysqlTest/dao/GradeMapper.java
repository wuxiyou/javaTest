package rare.mysqlTest.dao;

import rare.mysqlTest.Grade;

import java.util.HashMap;
import java.util.List;

public interface GradeMapper {

    /**
     * 查询单条班级信息
     * @param classNo 班级号
     * @return
     */
     Grade queryRowInfo(Integer classNo);


    /**
     * 查询班级信息
     * @return
     */
     List<HashMap<String,Object>> queryListInfo();

     List<Grade> queryListInfoObject();

    /**
     * 添加班级信息
     * @param grade 班级对象
     */
     int insertInfo(Grade grade);

    /**
     * 更新班级信息
     * @param param 更新字段
     */
     void updateInfo(HashMap<String, Object> param);

     Grade gradeRowInfo(Integer classNo);
}
