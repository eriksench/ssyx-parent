package com.zyx.ssyx.acl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyx.ssyx.acl.mapper.RolePermissionMapper;
import com.zyx.ssyx.acl.service.RolePermissionService;
import com.zyx.ssyx.model.acl.RolePermission;
import org.springframework.stereotype.Service;

@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission>
        implements RolePermissionService {
}
