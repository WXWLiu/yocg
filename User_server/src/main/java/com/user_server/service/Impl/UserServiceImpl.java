package com.user_server.service.Impl;

import com.user_server.entity.User;
import com.user_server.mapper.UserMapper;
import com.user_server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    /**
     * 查询所有用户
     *
     * @return List所有用户
     */
    @Override
    public List<User> findUser() {
        return userMapper.selectList(null);
    }

    /**
     * 通过手机号和密码查询用户
     *
     * @param user
     * @return
     */
    @Override
    public User findUserBypwdandtp(User user) {
        return userMapper.findUserBypwdandtp(user);
    }

    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    @Override
    public boolean insertUser(User user) {
        return userMapper.insertUser(user);
    }

    /**
     * 通过用户名查询用户
     *
     * @param user
     * @return
     */
    @Override
    public List<User> findUserByuname(User user) {
        return userMapper.findUserByuname(user);
    }
    /**
     * 通过电话号查询用户
     * @param user
     * @return
     */
    @Override
    public List<User> findUserBytele(User user) {
        return userMapper.findUserBytele(user);
    }

    /**
     * 获取她关注的人数
     * @param uid
     * @return
     */
    @Override
    public int getfollowcount(int uid) {
        return userMapper.getfollowcount(uid);
    }
    /**
     * 获取她粉丝的人数
     * @param ouid
     * @return
     */
    @Override
    public int getfanscount(int ouid) {
        return userMapper.getfanscount(ouid);
    }


//    @Override
//    public List<String> getImgName() {
//        return userMapper.getImgName();
//    }
private final String uploadDir = "User_server/src/main/resources/images"; // 设置上传文件存储路径

    @Transactional
    public String uploadFile(MultipartFile file,User user) throws IOException {
        String originalFileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uniqueFileName = UUID.randomUUID().toString() + "_" + originalFileName;

        // 保存文件到服务器
        file.transferTo(new File(uploadDir + "/" + uniqueFileName));
        // 将文件名保存到数据
        userMapper.insert(user);
        return uniqueFileName;
    }

////    @Transactional
////    public boolean updateFileName(Long id, String newFilename) {
////        FileEntity fileEntity = userMapper.selectById(id);
////        if (fileEntity == null) {
////            return false;
////        }
////        fileEntity.setFilename(newFilename);
////        userMapper.updateById(fileEntity);
////        return true;
////    }

}
