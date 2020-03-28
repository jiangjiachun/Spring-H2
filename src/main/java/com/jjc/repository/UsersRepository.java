package com.jjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.jjc.entity.UsersEntity;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long>, QueryByExampleExecutor<UsersEntity> {

}
