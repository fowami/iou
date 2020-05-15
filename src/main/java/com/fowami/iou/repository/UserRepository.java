/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fowami.iou.repository;

import com.fowami.iou.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author fowami
 */

public interface UserRepository extends JpaRepository<User, Long>{
    
   @Query("SELECT c.user FROM User c  order by c.user asc ")
    public List<User> getAllUsers();

}
