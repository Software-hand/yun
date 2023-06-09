package com.tencent.wxcloudrun.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tencent.wxcloudrun.config.Result;
import com.tencent.wxcloudrun.entity.Permission;
import com.tencent.wxcloudrun.entity.Role;
import com.tencent.wxcloudrun.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Resource
    private PermissionService permissionService;

    @PostMapping
    public Result<?> save(@RequestBody Permission permission) {
        return Result.success(permissionService.save(permission));
    }

    @PutMapping
    public Result<?> update(@RequestBody Permission permission) {
        return Result.success(permissionService.updateById(permission));
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id) {
        permissionService.delete(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result<Permission> findById(@PathVariable Long id) {
        return Result.success(permissionService.getById(id));
    }

    @GetMapping
    public Result<List<Permission>> findAll() {
        return Result.success(permissionService.list());
    }

    @GetMapping("/page")
    public Result<IPage<Permission>> findPage(@RequestParam(required = false, defaultValue = "") String name,
                                              @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                              @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return Result.success(permissionService.page(new Page<>(pageNum, pageSize), Wrappers.<Permission>lambdaQuery().like(Permission::getName, name)));
    }

    @PostMapping("/getByRoles")
    public Result<List<Permission>> getByRoles(@RequestBody List<Role> roles) {
        return Result.success(permissionService.getByRoles(roles));
    }

}
