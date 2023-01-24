package world.rfch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import world.rfch.enums.PostStatus;
import world.rfch.jpa.entity.CommentEntity;
import world.rfch.jpa.entity.PostEntity;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.jpa.repository.CommentRepository;
import world.rfch.jpa.repository.PostRepository;
import world.rfch.jpa.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class SocialMediaApplication {
    public static void main(String[] args){
        SpringApplication.run(SocialMediaApplication.class);
    }
}
