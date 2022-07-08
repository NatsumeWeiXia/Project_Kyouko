package th.weixia.kyouko.pojo;

import java.sql.Timestamp;

/**
 * @author: weixia
 * @create: 2022-07-05 22:27
 * @Description: chat data
 */
public class ChatData {

    // 用户账号
    private String userId;
    // 用户名称
    private String userName;
    // 群组ID
    private String groupId;
    // 群组名称
    private String groupName;
    // 内容
    private String content;
    // 文件类型
    private Integer fileType;
    // 文件ID
    private String fileId;
    // 发送时间
    private Timestamp chatDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public Timestamp getChatDate() {
        return chatDate;
    }

    public void setChatDate(Timestamp chatDate) {
        this.chatDate = chatDate;
    }
}
