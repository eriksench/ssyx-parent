package com.zyx.ssyx.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyx.ssyx.model.product.Comment;
import com.zyx.ssyx.product.mapper.CommentMapper;
import com.zyx.ssyx.product.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
}
