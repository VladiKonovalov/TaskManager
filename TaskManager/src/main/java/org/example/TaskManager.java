package org.example;
import enums.Priority;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class TaskManager {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "priority")
 private Priority priority;

    @Column(name = "name")
    private String name;

@Basic(optional = false)
@CreationTimestamp
@Column(name = "date")
@Temporal(TemporalType.TIMESTAMP)
private Date date = new Date(); // initialize created date    @CreatedDate
//    @Column(name = "date")
//    @Temporal(TemporalType.TIMESTAMP)
//    private String date;
    public TaskManager() {

    }

public String GetTime(){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss");
    ZonedDateTime now = ZonedDateTime.now();
    return  dtf.format(now);                  // 2021/03/22 16:37:15

}
    public TaskManager(String name,Priority priority) {
        super();
        this.date= new Date();
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name= name;
    }

    public Long getId() {
        return id;
    }
    public Priority getPriority() {
        return priority;
    }
    public Date getDate() {
        return date;
    }
    public void setPriority(Priority priority) {
        this.priority=priority;
    }
    public void setId(Long id) {
        this.id=id;
    }
    public void setDate() {
        this.date=new Date(); ;
    }

//    public void setPriority(String priority) {
//        this.priority = priority;
//    }

}