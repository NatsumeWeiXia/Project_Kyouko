package th.weixia.kyouko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
/**
 * @author:  weixia
 * @create: 2022-06-25 23:00
 * @Description: Kyouko Robot
 */
@ComponentScan("th.weixia.kyouko")
@EnableAutoConfiguration
public class Kyouko {
    private static final Logger LOGGER = LoggerFactory.getLogger(Kyouko.class);

    public static void main(String[] args) {

        LOGGER.info("Kyouko Application Starting ... ...");

        SpringApplication.run(Kyouko.class, args);

        LOGGER.info("Kyouko Application Starting SUCCESS !");
    }
}