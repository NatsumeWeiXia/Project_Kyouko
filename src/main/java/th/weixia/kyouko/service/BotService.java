package th.weixia.kyouko.service;

import org.springframework.stereotype.Service;

/**
 * @author: weixia
 * @create: 2022-06-29 22:37
 * @Description: chat bot service
 */
@Service
public interface BotService {

    boolean startBot(long user, String pwd);

}
