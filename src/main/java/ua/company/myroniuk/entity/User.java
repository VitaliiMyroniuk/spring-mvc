package ua.company.myroniuk.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author Vitalii Myroniuk
 */
public class User {

    @NotEmpty(message = "{empty.login.error}")
    private String login;

    @Size(min = 4, message = "{password.size.error}")
    private String password;

    private String name;

    private Integer age;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
