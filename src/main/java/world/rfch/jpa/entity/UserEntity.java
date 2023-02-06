package world.rfch.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import world.rfch.enums.AuthProvider;
import world.rfch.enums.Gender;
import world.rfch.enums.MaritalStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.EnumType.STRING;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Enumerated(STRING)
    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;

    @Lob
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

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Enumerated(STRING)
    private AuthProvider authProvider;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "follow",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id"))
    private List<UserEntity> followedUserList;

    @ManyToMany(mappedBy = "followedUserList",fetch = FetchType.EAGER)
    private List<UserEntity> followerUserList;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "senderUser")
    private List<MessageEntity> sentMessages;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "receiverUser")
    private List<MessageEntity> receivedMessages;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "friendship",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id"))
    private List<UserEntity> friendList;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "friend_request",
            joinColumns = @JoinColumn(name = "sender_id"),
            inverseJoinColumns = @JoinColumn(name = "receiver_id"))
    private List<UserEntity> sentFriendRequests;

    @ManyToMany(mappedBy = "sentFriendRequests")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<UserEntity> receivedFriendRequests;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tagged_user_id"))
    private List<PostEntity> postListThatUserIsTaggedIn;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "post_like",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "liked_post_id"))
    private List<PostEntity> likedPostList;

    @OneToMany(mappedBy = "user")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<SocialMediaEntity> socialMediaList;

    @OneToMany(mappedBy = "user")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CommentEntity> commentList;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "comment_like",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "comment_id"))
    private List<CommentEntity> likedCommentList;

    @OneToMany(mappedBy = "user")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PostEntity> postEntityList;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_authorities",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")})
    @BatchSize(size = 20)
    @Builder.Default
    @ToString.Exclude
    private Set<Authority> authorities = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(username, that.username) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(countryName, that.countryName) && Objects.equals(cityName, that.cityName) && gender == that.gender && Objects.equals(dateOfBirth, that.dateOfBirth) && maritalStatus == that.maritalStatus && Objects.equals(address, that.address) && Objects.equals(contactNumber, that.contactNumber) && Objects.equals(contactEmail, that.contactEmail) && Objects.equals(followerCount, that.followerCount) && Objects.equals(followCount, that.followCount) && Objects.equals(postCount, that.postCount) && Objects.equals(url, that.url) && Objects.equals(about, that.about) && Objects.equals(image, that.image) && Objects.equals(registrationDate, that.registrationDate) && authProvider == that.authProvider && Objects.equals(followedUserList, that.followedUserList) && Objects.equals(followerUserList, that.followerUserList) && Objects.equals(sentMessages, that.sentMessages) && Objects.equals(receivedMessages, that.receivedMessages) && Objects.equals(friendList, that.friendList) && Objects.equals(sentFriendRequests, that.sentFriendRequests) && Objects.equals(receivedFriendRequests, that.receivedFriendRequests) && Objects.equals(postListThatUserIsTaggedIn, that.postListThatUserIsTaggedIn) && Objects.equals(likedPostList, that.likedPostList) && Objects.equals(socialMediaList, that.socialMediaList) && Objects.equals(commentList, that.commentList) && Objects.equals(likedCommentList, that.likedCommentList) && Objects.equals(postEntityList, that.postEntityList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username, name, surname, email, password, countryName, cityName, gender, dateOfBirth, maritalStatus, address, contactNumber, contactEmail, followerCount, followCount, postCount, url, about, image, registrationDate, authProvider, followedUserList, followerUserList, sentMessages, receivedMessages, friendList, sentFriendRequests, receivedFriendRequests, postListThatUserIsTaggedIn, likedPostList, socialMediaList, commentList, likedCommentList, postEntityList);
    }

    @PrePersist
    public void prePersist() {
        registrationDate = LocalDateTime.now();
    }


}
