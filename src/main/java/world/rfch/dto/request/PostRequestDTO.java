package world.rfch.dto.request;

import com.sun.istack.NotNull;
import lombok.*;
import world.rfch.enums.PostStatus;
import world.rfch.jpa.entity.PostEntity;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.service.PostService;
import world.rfch.service.UserService;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class PostRequestDTO {

    private final UserService userService;
    private final PostService postService;

    @NotNull
    private Long userId;

    @NotBlank(message = "Please fill the all field")
    private String content;

    private Date date;

    @NotBlank
    private String source;

    @NotNull
    private PostStatus status;

    List<Long> taggedUserIdList;

    public PostEntity toEntity(){
        List<UserEntity> taggedUserEntityList = new ArrayList<>();
        for(Long a : taggedUserIdList){
            taggedUserEntityList.add(userService.findById(a));
        }
        return PostEntity.builder()
                .user(userService.findById(this.userId))
                .content(this.content)
                .date(this.date)
                .source(this.source)
                .status(this.status)
                .taggedUserList(taggedUserEntityList)
                .build();
    }

}
