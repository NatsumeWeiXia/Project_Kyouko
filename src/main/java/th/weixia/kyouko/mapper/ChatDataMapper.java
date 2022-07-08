package th.weixia.kyouko.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import th.weixia.kyouko.pojo.ChatData;

/**
 * @author: weixia
 * @create: 2022-07-03 23:19
 * @Description: chat data mapper
 */
@Mapper
@Repository
public interface ChatDataMapper {

    int insert(ChatData chatData);
}
