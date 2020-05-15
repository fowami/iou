/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fowami.iou.repository;

import com.fowami.iou.model.Iou;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Developer
 */
@Repository
public interface IouRepository extends JpaRepository<Iou, Long>{
    
}
