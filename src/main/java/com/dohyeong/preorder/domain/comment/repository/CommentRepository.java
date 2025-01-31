package com.dohyeong.preorder.domain.comment.repository;

import com.dohyeong.preorder.domain.comment.entity.Comment;
import com.dohyeong.preorder.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    Optional<Comment> findById(long comment_id);
}
