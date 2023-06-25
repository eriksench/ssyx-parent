package com.zyx.ssyx.acl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyx.ssyx.acl.mapper.AdminRoleMapper;
import com.zyx.ssyx.acl.service.AdminRoleService;
import com.zyx.ssyx.model.acl.AdminRole;
import org.springframework.stereotype.Service;

/**
 * 用户角色服务实现类
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole>
        implements AdminRoleService {
}
