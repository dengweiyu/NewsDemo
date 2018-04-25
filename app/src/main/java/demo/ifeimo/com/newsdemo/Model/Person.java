package demo.ifeimo.com.newsdemo.Model;

/**
 * Created by Wing on 2018/4/13.
 */

public class Person {
    public int id;
    public String member_id;
    public String password;
    public String sex;
    public String nick;
    public String pic;

    public Person() {

    }

    public Person(int id, String member_id, String password, String sex, String nick, String pic) {
        this.id = id;
        this.member_id = member_id;
        this.password = password;
        this.sex = sex;
        this.nick = nick;
        this.pic = pic;

    }

}
