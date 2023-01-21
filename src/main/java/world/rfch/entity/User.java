package world.rfch.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "user")
public class User extends BaseEntity {
    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String country_name;
    private String city_name;
    private char gender;
    private Date date_of_birth;
    private Integer marital_status_id;
    private String address;
    private Integer contact_number;
    private String contact_email;
    private Integer follower_count;
    private Integer follow_count;
    private Integer post_count;
    private String url;
    private String about;
    private String image;
}
