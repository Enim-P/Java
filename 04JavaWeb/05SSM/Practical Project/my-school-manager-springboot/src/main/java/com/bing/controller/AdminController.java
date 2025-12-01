package com.bing.controller;

import com.bing.pojo.Admin;
import com.bing.pojo.PageBean;
import com.bing.pojo.ReturnData;
import com.bing.pojo.Student;
import com.bing.service.AdminService;
import com.bing.util.AliOSSUtils;
import com.bing.util.JwtUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 用户控制器
 */
@Api(tags = "用户相关接口")   // Swagger的注解，用于定义控制器的描述
@RestController
@RequestMapping("/admins")
public class AdminController {
    @Resource
    AdminService adminService;
    @Resource
    AliOSSUtils aliOSSUtils;

    // 添加用户
    @ApiOperation("添加用户")   // Swagger的注解，用于定义控制器方法的描述
    @PostMapping("/add")
    public ReturnData add(@RequestBody Admin admin){
        Admin retAdmin = adminService.findByLoginId(admin.getLoginId());
        if(retAdmin!=null){
            return ReturnData.error("添加失败！登录名重复！");
        }
        int rows = adminService.insert(admin);
        if(rows>0){
            return ReturnData.success();
        }else{
            return ReturnData.error("添加失败！");
        }
    }

    // 注册用户
    @ApiOperation("注册用户")
    @PostMapping("/register")
    public ReturnData regisger(@RequestBody Admin admin){
        Admin retAdmin = adminService.findByLoginId(admin.getLoginId());
        if(retAdmin!=null){
            return ReturnData.error("注册失败！登录名重复！");
        }
        int rows = adminService.register(admin);
        if(rows>0){
            return ReturnData.success();
        }else{
            return ReturnData.error("注册失败！");
        }
    }

    // 登录系统
    @ApiOperation("登录系统")
    @PostMapping("/login")
    public ReturnData login(@RequestBody Admin admin){
        Admin retAdmin = adminService.findByLoginId(admin.getLoginId());
        if(retAdmin==null){
            return ReturnData.error("登录失败！登录名错误！");
        }
        if(retAdmin.getLoginPwd().equals(admin.getLoginPwd())){
            // 登录成功后，要生产当前用户的唯一令牌
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",retAdmin.getId());
            claims.put("loginId",retAdmin.getLoginId());
            claims.put("name",retAdmin.getName());
            String jwt = JwtUtils.generateJwt(claims);
            // 将生成的jwt令牌信息，发生给前端
            return ReturnData.success(jwt);
        }else{
            return ReturnData.error("登录失败！密码错误！");
        }
    }

    // 修改用户
    @ApiOperation("修改用户")
    @PutMapping("/update")
    public ReturnData update(@RequestBody Admin admin){
        int rows = adminService.update(admin);
        if(rows>0){
            return ReturnData.success();
        }else{
            return ReturnData.error("修改失败！");
        }
    }

    // 修改密码
    @ApiOperation("修改密码")
    @PutMapping("/updatePwd")
    public ReturnData updatePwd(@RequestBody Map admin){
        Integer id = (Integer)admin.get("id");
        String oldPwd = (String)admin.get("oldPwd");
        String newPwd = (String)admin.get("newPwd");
        int rows = adminService.updatePwd(id, oldPwd, newPwd);
        if(rows>0){
            return ReturnData.success();
        }else{
            return ReturnData.error("修改失败！原始密码错误！");
        }
    }

    // 删除
    @ApiOperation("删除用户")  // 路径参数也是用户@ApiParam描述
    @DeleteMapping("/{id}")
    public ReturnData delete(@ApiParam("用户id") @PathVariable Integer id){
        int rows = adminService.delete(id);
        if(rows>0){
            return ReturnData.success();
        }else{
            return ReturnData.error("删除失败！");
        }
    }

    // 根据登录名查询
    @ApiOperation("根据登录名查询用户信息")  // @ApiParam是给请求参数添加描述信息
    @GetMapping("/findByLoginId")
    public ReturnData findByloginId(@ApiParam("登录名") @RequestParam String loginId){
        Admin admin = adminService.findByLoginId(loginId);
        return ReturnData.success(admin);
    }

    // 根据条件+分页查询用户
    @ApiOperation("条件+分页查询用户信息")
    @GetMapping
    public ReturnData findByCondition(@ApiParam("类型") @RequestParam(required = false,defaultValue = "") String type,
                                      @ApiParam("姓名") @RequestParam(required = false,defaultValue = "") String name,
                                      @ApiParam("页码") @RequestParam(required = false,defaultValue = "1") Integer pageIndex,
                                      @ApiParam("每页数量") @RequestParam(required = false,defaultValue = "10") Integer pageSize){
        PageBean<Admin> pageBean = adminService.findByCondition(type, name,pageIndex,pageSize);
        return ReturnData.success(pageBean);
    }

    // 上传头像（阿里云OSS对象存储）
    @ApiOperation("上传头像（阿里云）")
    @PostMapping("/upload")
    public ReturnData uploadOSS(MultipartFile photo) throws IOException {
        // 调用阿里云OSS工具类进行文件上传
        String url = aliOSSUtils.upload(photo);
        return ReturnData.success(url);
    }

    // 上传头像（本地存储）
    @ApiOperation("上传头像（本地）")
    @PostMapping("/upload2")
    public ReturnData uploadLocal(MultipartFile photo) throws IOException {
        //获取原始文件名
        String originalFilename = photo.getOriginalFilename();
        //获取文件名中.的位置
        int index = originalFilename.lastIndexOf(".");
        //获取文件的扩展名
        String extname = originalFilename.substring(index);
        //定义新的文件名，使用UUID.randomUUID()返回一个唯一的名称
        String newFileName = UUID.randomUUID().toString()+extname;
        //上传到本地
        photo.transferTo(new File("/Users/a1/Desktop/mine/带班/班级授课/KG37/05SSM/项目实战/MySchoolManager/src/main/resources/photo/"+newFileName));
        return ReturnData.success("头像上传成功！");
    }
}
