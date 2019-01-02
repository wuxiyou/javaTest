package rare.mysqlTest;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import rare.mysqlTest.dao.CardMapper;
import rare.mysqlTest.dao.GradeMapper;
import rare.mysqlTest.dao.UserMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserTest {


    /* 查询班级信息  start */

    private static void queryGradeRow(GradeMapper gradeMapper){
        Grade grade = gradeMapper.queryRowInfo(2);
        System.out.println(grade);
    }

    private static void queryListInfo(GradeMapper gradeMapper) {
        List<HashMap<String, Object>> data = gradeMapper.queryListInfo();
        System.out.println(data);
    }

    private static void queryListInfoObject(GradeMapper gradeMapper){
        List<Grade> listInfo = gradeMapper.queryListInfoObject();
        System.out.println(listInfo);
    }

    private static void insertGradeInfo(GradeMapper gradeMapper){
        Grade grade = new Grade(5,"g5");
        int result = gradeMapper.insertInfo(grade);
        System.out.println("影响记录条数："+result);
        System.out.println("返回主键值: "+ grade.getId());
    }


    /**
     * 延时加载数据  分步查询数据
     * @param gradeMapper
     */
    private static void gradeRowInfo(GradeMapper gradeMapper) {
        Grade data = gradeMapper.gradeRowInfo(2);
        System.out.println(data);

        // 当用到 学生信息时 才会进行加载
        /*List<User> users = data.getUser();
        System.out.println(users);*/
    }

    /* 查询班级信息 end   */

    /* 查询学生具体信息 */
    public static void cardRowInfo(CardMapper cardMapper){
        Card card = cardMapper.cardRowInfo(2);
        System.out.println(card);
    }


    /* 查询 学生 信息*/
    private static void userInfoByClassNo(UserMapper userMapper) {
        List<User> users = userMapper.userInfoByClassNo(2);
        System.out.println(users);
    }


    /**
     *  测试返回结果是 resultMap
     * @param userMapper
     */
    private static void queryUserResultMap(UserMapper userMapper){
        List<User> list = userMapper.queryUserResultMap();
        System.out.println(list);
    }

    /**
     * 测试返回结果为HashMap
     * @param userMapper
     */
    private static void queryUserByHashMap(UserMapper userMapper){
        HashMap<String,Object> hashMap = userMapper.queryUserByHashMap(2);
        System.out.println(hashMap);
    }

    /**
     * 返回结果为多个HashMap 的 list
     * @param userMapper
     */
    private static void queryUserByListHashMap(UserMapper userMapper){
        List<HashMap<String, Object>> list = userMapper.queryUserByListHashMap();
        System.out.println(list);
    }

    /**
     * 输入参数为array
     * @param userMapper
     */
    private static void queryUserListByArray(UserMapper userMapper) {
        int[] arr = {1,2,4};
        List<User> list = userMapper.queryUserListByArray(arr);
        System.out.println(list);
    }


    /**
     * 输入参数为 list
     * @param userMapper
     */
    private static void queryUserListByList(UserMapper userMapper) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);

        List<User> userList = userMapper.queryUserListByList(list);
        System.out.println(userList);
    }

    private static void queryUserByCondition(UserMapper userMapper) {
        User user = new User();
        //user.setAge(8);
        user.setName("%R%");
        List<User> users = userMapper.queryUserByCondition(user);
        System.out.println(users);
    }

    private static void queryByAdType(UserMapper userMapper){
        List<HashMap<String, Object>> list = userMapper.queryByAdType(1,2,4);
        System.out.println(list);
    }



    /**
     *  查询参数是一个hashmap
     *  返回参数是 一个List<HashMap<String,Object>>
     * @param userMapper
     */
    private static void queryUserByHashMapParams(UserMapper userMapper) {
        HashMap<String,Object> hashMap = new HashMap<>(2);
        hashMap.put("name", "%R%");
        List<HashMap<String,Object>> list = userMapper.queryUserByHashMapParams(hashMap);
        System.out.println(list);
    }
    private static void queryUserByHashMapParams1(UserMapper userMapper) {
        HashMap<String,Object> hashMap = new HashMap<>(2);
        hashMap.put("name", "%R%");
        List<HashMap<String,Object>> list = userMapper.queryUserByHashMapParams1(hashMap);
        System.out.println(list);
    }


    private static void queryCardInfoWithUser(UserMapper userMapper) {
        List<User> list = userMapper.queryCardInfoWithUser();
        System.out.println(list);
    }


    private static void queryClassWithUserInfo(UserMapper userMapper) {
        List<Grade> grade = userMapper.queryClassWithUserInfo(2);
        for (Grade grade1: grade) {
            if (grade1.getUser() != null) {
                for (User user : grade1.getUser()){
                    System.out.println(user);
                }
            }
        }
        System.out.println(grade);
    }


    private static void selectListUser(UserMapper userMapper){
        List<User> list = userMapper.selectListUser();
        System.out.println(list);
    }

    private static void selectUser(UserMapper userMapper){
        User user = userMapper.selectUser(2);
        System.out.println(user);
    }

    public static void main(String[] args) throws IOException{

        String resource = "conf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //User user = sqlSession.selectOne("selectUser", 1);
        //System.out.println(user.getName());
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        GradeMapper gradeMapper = sqlSession.getMapper(GradeMapper.class);
        CardMapper cardMapper = sqlSession.getMapper(CardMapper.class);
        // 测试用例 start
        //queryUserResultMap(userMapper);
        //queryUserByHashMap(userMapper);
        //queryUserByListHashMap(userMapper);
        //queryUserListByArray(userMapper);
        //queryUserListByList(userMapper);
        //queryUserByCondition(userMapper);
        //queryByAdType(userMapper);
        //queryUserByHashMapParams(userMapper);
        //queryUserByHashMapParams1(userMapper);
        //queryCardInfoWithUser(userMapper);
        //queryClassWithUserInfo(userMapper);

        //selectListUser(userMapper);
        //selectUser(userMapper);


        /* 查询班级 */
        //queryGradeRow(gradeMapper);
        //queryListInfo(gradeMapper);
        //queryListInfoObject(gradeMapper);
        //insertGradeInfo(gradeMapper);
        gradeRowInfo(gradeMapper);



        /* 查询学生卡信息 */
        //cardRowInfo(cardMapper);


        /* 查询学生信息 */
        //userInfoByClassNo(userMapper);

        sqlSession.commit();
        sqlSession.close();
    }
}
