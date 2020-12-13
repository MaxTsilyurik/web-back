package com.example.webback.business.dao;

import com.example.webback.business.entity.FriendEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface  FriendsRepository extends JpaRepository<FriendEntity, Long> {
}
