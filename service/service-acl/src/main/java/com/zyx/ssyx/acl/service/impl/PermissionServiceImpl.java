package com.zyx.ssyx.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zyx.ssyx.acl.service.RolePermissionService;
import com.zyx.ssyx.acl.utils.PermissionHelper;
import com.zyx.ssyx.acl.mapper.PermissionMapper;
import com.zyx.ssyx.acl.service.PermissionService;
import com.zyx.ssyx.model.acl.AdminRole;
import com.zyx.ssyx.model.acl.Permission;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyx.ssyx.model.acl.Role;
import com.zyx.ssyx.model.acl.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 权限服务实现类
 * </p>
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
        implements PermissionService {

    @Autowired
    private RolePermissionService rolePermissionService;

    //获取所有菜单
    @Override
    public List<Permission> queryAllMenu() {
        //获取全部权限数据
        List<Permission> allPermissionList = baseMapper.selectList(new QueryWrapper<Permission>().orderByAsc("CAST(id AS SIGNED)"));

        //把权限数据构建成树形结构数据
        List<Permission> result = PermissionHelper.bulid(allPermissionList);
        return result;
    }

    //递归删除菜单
    @Override
    public boolean removeChildById(Long id) {
        List<Long> idList = new ArrayList<>();
        this.selectChildListById(id, idList);
        idList.add(id);
        baseMapper.deleteBatchIds(idList);
        return true;
    }

    /**
     * 根据角色查询权限
     *
     * @param roleId
     * @return
     */
    @Override
    public Map<String, Object> findPermissionByRoleId(Long roleId) {
        List<Permission> allPermissionList = baseMapper.selectList(null);

        //查询角色拥有的权限id
        List<RolePermission> existRolePermissionList = rolePermissionService.list(new QueryWrapper<RolePermission>().eq("role_id", roleId).select("permission_id"));
        List<Long> existPermissionList = existRolePermissionList.stream().map(c -> c.getPermissionId()).collect(Collectors.toList());

        //对权限分类
        List<Permission> assignPermissionList = new ArrayList<>();
        for (Permission permission : assignPermissionList) {
            //已分配
            if (existPermissionList.contains(permission.getId())) {
                assignPermissionList.add(permission);
            }
        }

        Map<String, Object> permissionMap = new HashMap<>();
        permissionMap.put("assignPermissions", assignPermissionList);
        permissionMap.put("allPermissionList", allPermissionList);

        return permissionMap;
    }

    /**
     * 保存角色-权限信息
     *
     * @param roleId
     * @param permissionIds
     */
    @Override
    public void saveRolePermissionRelationShip(Long roleId, Long[] permissionIds) {
        //删除用户分配的角色数据
        rolePermissionService.remove(new QueryWrapper<RolePermission>().eq("role_id", roleId));

        //分配新的角色
        List<RolePermission> rolePermissionList = new ArrayList<>();
        for (Long permissionId : permissionIds) {
            if (StringUtils.isEmpty(permissionId)) continue;
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionId);
            rolePermissionList.add(rolePermission);
        }
        rolePermissionService.saveBatch(rolePermissionList);
    }

    /**
     * 递归获取子节点
     *
     * @param id
     * @param idList
     */
    private void selectChildListById(Long id, List<Long> idList) {
        List<Permission> childList = baseMapper.selectList(new QueryWrapper<Permission>().eq("pid", id).select("id"));
        childList.stream().forEach(item -> {
            idList.add(item.getId());
            this.selectChildListById(item.getId(), idList);
        });
    }
}
