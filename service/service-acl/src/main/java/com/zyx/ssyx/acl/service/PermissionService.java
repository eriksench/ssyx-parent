package com.zyx.ssyx.acl.service;

import com.alibaba.fastjson.JSONObject;
import com.zyx.ssyx.model.acl.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 权限服务接口
 * </p>
 */
public interface PermissionService extends IService<Permission> {

    //获取所有菜单列表
    List<Permission> queryAllMenu();

    //递归删除
    boolean removeChildById(Long id);

    /**
     * 根据角色查询权限
     * @param roleId
     * @return
     */
    Map<String, Object> findPermissionByRoleId(Long roleId);

    /**
     * 保存角色-权限信息
     * @param roleId
     * @param permissionIds
     */
    void saveRolePermissionRelationShip(Long roleId, Long[] permissionIds);
}