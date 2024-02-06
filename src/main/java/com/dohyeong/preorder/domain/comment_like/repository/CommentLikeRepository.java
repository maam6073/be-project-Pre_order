package com.dohyeong.preorder.domain.comment_like.repository;


import com.dohyeong.preorder.domain.comment_like.entity.CommentLike;
import com.dohyeong.preorder.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentLikeRepository extends JpaRepository<CommentLike,Long> {

}
