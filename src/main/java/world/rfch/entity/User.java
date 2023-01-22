package world.rfch.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class User extends BaseEntity {
    @Column(name = "username")
    private String username;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "country_name")
    private String country_name;
    @Column(name = "city_name")
    private String city_name;
    @Column(name = "gender")
    private char gender;
    @Column(name = "date_of_birth")
    private Date date_of_birth;
    //---
    @ManyToOne
    @JoinColumn(name = "marital_status_id")
    private MaritalStatus maritalStatus;
    //---
    @Column(name = "address")
    private String address;
    @Column(name = "contact_number")
    private Integer contact_number;
    @Column(name = "contact_email")
    private String contact_email;
    @Column(name = "follower_count")
    private Integer follower_count;
    @Column(name = "follow_count")
    private Integer follow_count;
    @Column(name = "post_count")
    private Integer post_count;
    @Column(name = "url")
    private String url;
    @Column(name = "about")
    private String about;
    @Column(name = "image")
    private String image;
    @ManyToMany(mappedBy = "followerUserList")
    private List<User> followUserList;
    @ManyToMany(mappedBy = "followUserList")
    @JoinTable(
            name = "follow",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id"))
    private List<User> followerUserList;

    @OneToMany
    @JoinColumn(name = "sended_messages")
    private List<Message> sendedMessages;

    @OneToMany
    @JoinColumn(name = "received_messages")
    private List<Message> receivedMessages;

}
