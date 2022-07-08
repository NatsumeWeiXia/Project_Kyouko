package th.weixia.kyouko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import th.weixia.kyouko.service.BotService;

import java.time.Duration;

/**
 * @author: weixia
 * @create: 2022-07-05 23:15
 * @Description: start listener
 */
@Order(1)
@Component
public class BotStartRunner implements ApplicationRunner {

    private final BotService botService;

    @Value("${BotConfig.account}")
    private long account;
    @Value("${BotConfig.password}")
    private String password;

    @Autowired
    public BotStartRunner(BotService botService) {
        this.botService = botService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        botService.startBot(account, password);
    }

}
