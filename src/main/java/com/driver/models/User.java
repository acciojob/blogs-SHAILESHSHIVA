
package com.driver.models;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName = "test";
    private String lastName = "test";
    private String username;
    private String password;

    //Database mapping

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JoinColumn
    private List<Blog> blogList;

    public User(){

    }

    public User(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public User(int id, String firstName, String lastName, String username, String password, List<Blog> blogList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.blogList = blogList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}