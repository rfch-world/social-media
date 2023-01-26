package world.rfch.dto;

import lombok.*;
import world.rfch.jpa.entity.SocialMediaEntity;
import world.rfch.service.UserService;

@Data
@Builder
@RequiredArgsConstructor
public class SocialMediaDTO {

    private final UserService userService;

    private Long userId;

    private String url;

    public SocialMediaEntity toEntity(){
        return SocialMediaEntity.builder()
                .user(userService.findById(userId))
                .url(url)
                .build();
    }

}
