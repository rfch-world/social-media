package world.rfch.service;

import org.springframework.stereotype.Service;
import world.rfch.jpa.entity.MessageEntity;
import world.rfch.jpa.entity.UserEntity;

import java.util.List;

@Service
public interface MessageService {
    List<MessageEntity> findAllByReceiverUserAndSenderUserOrderByDateDesc
            (UserEntity senderUser, UserEntity receiverUser);


MessageEntity findById(Long id);

void save(MessageEntity messageEntity);
List<MessageEntity> findAllMessages();

}
