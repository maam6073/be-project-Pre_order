package com.dohyeong.preorder.domain.comment.repository;

import com.dohyeong.preorder.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}
