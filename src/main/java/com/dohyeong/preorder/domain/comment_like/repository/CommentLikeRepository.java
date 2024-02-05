package com.dohyeong.preorder.domain.comment_like.repository;

import com.dohyeong.preorder.domain.comment.entity.Comment;
import com.dohyeong.preorder.domain.comment_like.entity.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CommentLikeRepository extends JpaRepository<CommentLike,Long> {

}
