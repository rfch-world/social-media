package world.rfch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import world.rfch.enums.PostStatus;
import world.rfch.jpa.repository.PostRepository;
import world.rfch.jpa.repository.UserRepository;

import java.util.Arrays;

@SpringBootApplication
public class SocialMediaApplication {

    @Autowired
    PostRepository postRepository;
    public static void main(String[] args){
        SpringApplication.run(SocialMediaApplication.class);
    }
    @Component
    public class CommandLineAppStartupRunner implements CommandLineRunner {
        private final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);
        @Override
        public void run(String...args) throws Exception {
            System.out.println(postRepository.findAllByStatusOrderByLikeCountDescDateAsc(PostStatus.PUBLIC).get(1).getSource());
            logger.info(Arrays.toString(args));
        }
    }
}
