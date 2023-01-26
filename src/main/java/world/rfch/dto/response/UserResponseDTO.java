package world.rfch.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import world.rfch.dto.SocialMediaDTO;
import world.rfch.enums.Gender;
import world.rfch.enums.MaritalStatus;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    private String username;

    private String name;

    private String surname;

    private String email;

    private String password;

    private String countryName;

    private String cityName;

    private Gender gender;

    private Date dateOfBirth;

    private MaritalStatus maritalStatus;

    private String address;

    private String contactNumber;

    private String contactEmail;

    private Integer followerCount;

    private Integer followCount;

    private Integer postCount;

    private String url;

    private String image;

    private Date registrationDate;

    private List<UserResponseDTO> followedUserList;

    private List<UserResponseDTO> followerUserList;

    private List<MessageResponseDTO> sentMessages;

    private List<MessageResponseDTO> receivedMessages;

    private List<UserResponseDTO> friendList;

    private List<UserResponseDTO> sentFriendRequests;

    private List<UserResponseDTO> receivedFriendRequests;

    private List<PostResponseDTO> postListThatUserIsTaggedIn;

    private List<PostResponseDTO> likedPostList;

    private List<SocialMediaDTO> socialMediaList;

    private List<CommentResponseDTO> commentList;

    private List<CommentResponseDTO> likedCommentList;

    private List<PostResponseDTO> postList;

}
