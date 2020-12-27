package com.example.webback.business.dao;

import com.example.webback.business.entity.FriendEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FriendsRepository extends JpaRepository<FriendEntity, Long> {
    boolean existsByFriendId(UUID friendId);

    FriendEntity findByFriendId(UUID friendId);

    void deleteByFriendIdAndUserId(UUID friendId, UUID userId);

    List<FriendEntity> findAllByUserId(UUID userId);
}
