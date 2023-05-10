package com.example.mpdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mpdemo.entity.User;
import com.example.mpdemo.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
//    @Autowired
    //弹幕建议用@Resource
    @Resource
    private UserMapper userMapper;

    @GetMapping("/user/findAll")
//    public List<User> find(){System.out.println(userMapper.find());return userMapper.find();}  //Mybatis写法，配合userMapper
//    public List<User> find(){return userMapper.selectList(null);} //Mybatis写法，使用BaseMapper中的方法
    public List<User> find(){return userMapper.selectAllUserAndOrders();}

//条件查询
    @GetMapping("/user/find")
    public List<User> findByCond(){
        QueryWrapper<User> queryWrapper = new QueryWrapper();
        queryWrapper.eq("username","zhangsan");
        return userMapper.selectList(queryWrapper);
    }

    //  分页查询
    @GetMapping("/user/findByPage")
    public IPage findByPage(int currentPage, int pageSize){
        //设置起始值及每页条数
        Page<User> page = new Page<>(currentPage,pageSize);
        IPage<User> iPage = userMapper.selectPage(page,null);
        return iPage;
    }


    @GetMapping("/user")
//    public String query(){
    //String改成List可以以json格式返回给前端，方便前后端分离
    public List query(){
//        List<User> list=userMapper.find();
        List<User> list=userMapper.selectList(null);
        System.out.println(list);
        System.out.println(UUID.randomUUID().toString());
        return list;
    }

    @PostMapping("/user")
    public String save(User user){
//        System.out.println(user);
        int i = userMapper.insert(user);
//        System.out.println(user);
        if(i>0){
            return "插入成功";
        }else{
            return "插入失败";
        }
    }
}
