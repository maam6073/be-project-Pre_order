package com.dohyeong.preorder.domain.post_like.repository;

import com.dohyeong.preorder.domain.member.entity.Member;
import com.dohyeong.preorder.domain.post_like.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

}
