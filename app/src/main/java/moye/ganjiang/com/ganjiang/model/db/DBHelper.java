package moye.ganjiang.com.ganjiang.model.db;

import java.util.List;

import moye.ganjiang.com.ganjiang.model.response.UserMeassageBean;

/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @description:
 */

public interface DBHelper {
    /**
     * 查询 用户信息
     *
     *
     */

    UserMeassageBean queryUserMessage(String ID);

    /**
     * 更新 用户信息
     *
     *
     */
    void updateUserMessage(UserMeassageBean bean);

    /**
     * 增加 用户信息
     *
     *
     */
    void insertUserMessage(UserMeassageBean bean);
    /**
     * 查询所有信息
     *
     *
     */
       List<UserMeassageBean> queryAllUsers();
}
