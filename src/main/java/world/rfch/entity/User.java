package world.rfch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private String countryName;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "gender")
    private char gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;

    @Column(name = "address")
    private String address;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "follower_count")
    private Integer followerCount;

    @Column(name = "follow_count")
    private Integer followCount;

    @Column(name = "post_count")
    private Integer postCount;

    @Column(name = "url")
    private String url;

    @Column(name = "about")
    private String about;

    @Column(name = "image")
    private String image;

    @ManyToMany
    @JoinTable(
            name = "follow",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id"))
    private List<User> followedUserList;

    @ManyToMany(mappedBy = "followedUserList")
    private List<User> followerUserList;

    @OneToMany(mappedBy = "senderUser")
    private List<Message> sentMessages;

    @OneToMany(mappedBy = "receiverUser")
    private List<Message> receivedMessages;

    @ManyToMany
    @JoinTable(
            name = "friendship",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private List<User> friendList;

    @ManyToMany
    @JoinTable(
            name = "friend_request",
            joinColumns = @JoinColumn(name = "sender_id"),
            inverseJoinColumns = @JoinColumn(name = "receiver_id"))
    private List<User> sentFriendRequests;

    @ManyToMany(mappedBy = "sentFriendRequests")
    private List<User> receivedFriendRequests;

    @ManyToMany
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tagged_user_id"))
    private List<Post> postListThatUserIsTaggedIn;

    @ManyToMany
    @JoinTable(
            name = "post_like",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "liked_post_id"))
    private List<Post> likedPostList;

    @OneToMany(mappedBy = "user")
    private List<SocialMedia> socialMediaList;

    @OneToMany(mappedBy = "user")
    private List<Comment> commentList;

    @ManyToMany
    @JoinTable(
            name = "comment_like",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private List<Comment> likedCommentList;



}
