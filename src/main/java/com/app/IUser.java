/**
 * 
 */
package com.app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface IUser extends CrudRepository<User, Long> {

}
