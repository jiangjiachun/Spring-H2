/**
 * 
 */
package com.jjc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jjc.entity.Unit;

/**
 * @author jjc
 *
 */
@Repository
public interface UnitRepository extends JpaRepository<Unit, Integer> {

}
