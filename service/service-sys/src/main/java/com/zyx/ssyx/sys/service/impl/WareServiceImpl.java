package com.zyx.ssyx.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyx.ssyx.sys.mapper.WareMapper;
import com.zyx.ssyx.model.sys.Ware;
import com.zyx.ssyx.sys.service.WareService;
import org.springframework.stereotype.Service;

@Service
public class WareServiceImpl extends ServiceImpl<WareMapper, Ware> implements WareService {
}
