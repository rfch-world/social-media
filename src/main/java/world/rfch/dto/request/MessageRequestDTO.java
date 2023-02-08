package world.rfch.dto.request;

import com.sun.istack.NotNull;
import lombok.*;
import world.rfch.jpa.entity.CommentEntity;
import world.rfch.jpa.entity.MessageEntity;
import world.rfch.service.UserService;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class    MessageRequestDTO {

    private final UserService userService;

    @NotNull
    private Long senderUserId;

    @NotNull
    private Long receiverUserId;

    @NotBlank
    private String content;

    @NotNull
    private Date date;

    public MessageEntity toEntity(){
        return MessageEntity.builder()
                .senderUser(userService.findById(this.senderUserId))
                .receiverUser(userService.findById(this.receiverUserId))
                .content(this.content)
                .date(this.date)
                .build();
    }

}
