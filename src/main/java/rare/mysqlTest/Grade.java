package rare.mysqlTest;

import java.util.List;

public class Grade {


    private int id;
    private int classNo;
    private String className;

    private List<User> user;

    public Grade() { }

    public Grade(int classNo, String className) {
        this.classNo = classNo;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "[" + getClass().getSimpleName()+"] classNo = "+ getClassNo() + " className = "+ getClassName();
    }
}
