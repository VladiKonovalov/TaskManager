package org.example;
import enums.Priority;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @NotBlank
    private String firstname;
    @NotBlank

    private String lastname;
    @Email
    @NotBlank
    private String email;

    @Size(min = 6, max = 20)
    private String password;

    @Basic(optional = false)
@CreationTimestamp
@Temporal(TemporalType.TIMESTAMP)
private Date createdDate = new Date(); // initialize created date    @CreatedDate
    public User() {

    }

public String GetTime(){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
    ZonedDateTime now = ZonedDateTime.now();
    return  dtf.format(now);                  // 2021/03/22 16:37:15

}
    public User( String firstname,String lastname,String email, String password) {
        super();
        this.createdDate= new Date();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;

    }
    public void setId(Long id) {
        this.id=id;
    }
    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname= firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname= lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email= email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password= password;
    }

    public Date getDate() {
        return createdDate;
    }
    public void setDate() {
        this.createdDate=new Date();
    }



}