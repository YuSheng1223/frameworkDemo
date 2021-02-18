package com.ly.repository;

import com.ly.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query(nativeQuery = true,value = "select u.id,u.age,u.name,d.pid,d.description from t_user u left join t_user_detail d on u.id = d.pid where u.id = :id")
    public Object queryUserById(@Param("id") long id );


}
