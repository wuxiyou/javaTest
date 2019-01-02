package rare.mysqlTest.dao;

import org.apache.ibatis.annotations.Param;
import rare.mysqlTest.Grade;
import rare.mysqlTest.User;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {
    /**
     * 通过id查询用户信息
     * @param id   用户id
     * @return     返回用户信息
     */
    User selectUser(Integer id);

    /**
     *  增加
     * @param user  对象
     */
    void saveUser(User user);


    List<User> selectListUser();

    HashMap<String, Object> selectOneUser();

    /**
     * 测试mapper 中的返回类型是 returnMap
     * @return
     */
    List<User> queryUserResultMap();


    /**
     *  返回单条结果为 HashMap 集合
     * @param id  记录id
     * @return
     */
    HashMap<String, Object> queryUserByHashMap(Integer id);

    /**
     * 返回多条记录
     * @return
     */
    List<HashMap<String, Object>> queryUserByListHashMap();

    /**
     *  输入参数为数组 子查询
     * @param arr
     * @return
     */
    List<User> queryUserListByArray(int[] arr);


    List<User> queryUserListByList(List<Integer> list);


    List<User> queryUserByCondition(User user);

    List<HashMap<String, Object>> queryByAdType(@Param("status") Integer... status);

    List<HashMap<String, Object>> queryUserByHashMapParams(HashMap<String, Object> param);

    /**
     *  注解传入适合传入单个参数 或者list 集合
     * @param param
     * @return
     */
    List<HashMap<String, Object>> queryUserByHashMapParams1(@Param("HashMap") HashMap<String, Object> param);


    /**
     * 一对一 查询
     * @return
     */
    List<User> queryCardInfoWithUser();

    /**
     *  一对多关联查询
     * @param classNo
     * @return
     */
    List<Grade> queryClassWithUserInfo(Integer classNo);

    /**
     *  根据班级号 查询学生信息
     * @param classId
     * @return
     */
    List<User> userInfoByClassNo(Integer classId);
}
