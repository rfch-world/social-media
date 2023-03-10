package world.rfch.service;

import org.springframework.stereotype.Service;
import world.rfch.jpa.entity.MessageEntity;
import world.rfch.jpa.entity.UserEntity;

import java.util.List;

public interface MessageService {

    List<MessageEntity> findAllByReceiverUserAndSenderUserOrderByDateDesc
            (UserEntity senderUser, UserEntity receiverUser);

    MessageEntity findById(Long id);

    MessageEntity save(MessageEntity messageEntity);

    void deleteById(Long id);

    List<MessageEntity> findAll();

}
