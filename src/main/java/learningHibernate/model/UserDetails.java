package main.java.learningHibernate.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String name;
    @Embedded
    private Address address;
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    @Lob
    private String description;

    //we can also use annotations near getter @Id,@Column(name="USER_ID) instead of near variables
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
