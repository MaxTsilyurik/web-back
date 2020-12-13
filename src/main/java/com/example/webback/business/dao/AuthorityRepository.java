package com.example.webback.business.dao;


import com.example.webback.business.entity.AuthorityEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends PagingAndSortingRepository<AuthorityEntity,Integer> {
}
