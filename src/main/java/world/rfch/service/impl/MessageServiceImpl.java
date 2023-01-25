package world.rfch.service.impl;

import org.springframework.stereotype.Service;
import world.rfch.jpa.entity.MessageEntity;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.jpa.repository.MessageRepository;
import world.rfch.service.MessageService;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    private  final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<MessageEntity> findAllByReceiverUserAndSenderUserOrderByDateDesc(UserEntity senderUser,
                                                                                 UserEntity receiverUser) {
        return messageRepository.findAllByReceiverUserAndSenderUserOrderByDateDesc(senderUser, receiverUser);
    }

    @Override
    public MessageEntity findById(Long id) {
        return messageRepository.findById(id).orElseThrow(() -> new RuntimeException("can not find message with given id"));
    }



    @Override
    public void save(MessageEntity messageEntity) {
messageRepository.save(messageEntity);
    }

    @Override
    public List<MessageEntity> findAllMessages() {
        return messageRepository.findAll();
    }


}
