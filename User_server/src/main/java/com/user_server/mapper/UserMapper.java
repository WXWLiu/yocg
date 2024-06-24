package com.user_server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.user_server.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 通过用户的电话号以及密码进行查询用户
     *
     * @param user
     * @return
     */
    public User findUserBypwdandtp(User user);

    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    public boolean insertUser(User user);

    /**
     * 通过用户名查找用户
     *
     * @param user
     * @return
     */
    public List<User> findUserByuname(User user);

    /**
     * 通过电话号查询用户
     *
     * @param user
     * @return
     */
    public List<User> findUserBytele(User user);


//    public List<String> getImgName();

    /**
     * 获取她关注的人数
     * @param uid
     * @return
     */
    public int getfollowcount(int uid);

    /**
     * 获取她粉丝的人数
     * @param ouid
     * @return
     */
    public int getfanscount(int ouid);

    /**
     * 更新图片通过id
     * @param user
     * @return
     */
    public int updatefileByid(User user);
}
