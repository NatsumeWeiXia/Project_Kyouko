package th.weixia.kyouko.service.impl;

import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.weixia.kyouko.mapper.ChatDataMapper;
import th.weixia.kyouko.pojo.ChatData;
import th.weixia.kyouko.service.BotService;

import java.sql.Timestamp;

/**
 * @author: weixia
 * @create: 2022-06-29 22:38
 * @Description: chat bot impl
 */
@Service
public class BotServiceImpl implements BotService {

    private static final Logger LOGGER =  LoggerFactory.getLogger(BotServiceImpl.class);

    private final ChatDataMapper chatDataMapper;

    @Autowired
    public BotServiceImpl(ChatDataMapper chatDataMapper) {
        this.chatDataMapper = chatDataMapper;
    }

    @Override
    public boolean startBot(long user, String pwd) {

        try {
            Bot bot = BotFactory.INSTANCE.newBot(user, pwd);

            bot.login();

            this.afterLogin(bot);

            return true;
        } catch (Exception e) {

            LOGGER.error("Start Chat Bot Failed !", e);

            return false;
        }
    }

    private void afterLogin(@NotNull Bot bot) {

        bot.getEventChannel().subscribeAlways(FriendMessageEvent.class, (event) -> {
            ChatData chatData = new ChatData();
            chatData.setChatDate(new Timestamp(event.getTime()));
            chatData.setUserId(String.valueOf(event.getSender().getId()));
            chatData.setUserName(event.getSenderName());
            chatData.setContent(event.getMessage().contentToString());
            chatDataMapper.insert(chatData);
        });

        bot.getEventChannel().subscribeAlways(GroupMessageEvent.class, groupMessageEvent -> {
            ChatData chatData = new ChatData();
            chatData.setChatDate(new Timestamp(groupMessageEvent.getTime()));
            chatData.setUserId(String.valueOf(groupMessageEvent.getSender().getId()));
            chatData.setUserName(groupMessageEvent.getSenderName());
            chatData.setContent(groupMessageEvent.getMessage().contentToString());
            chatData.setGroupId(String.valueOf(groupMessageEvent.getGroup().getId()));
            chatData.setGroupName(groupMessageEvent.getGroup().getName());
            chatDataMapper.insert(chatData);
        });
    }
}
