package org.mallen.test.quartz.boot.simple;

import org.springframework.data.repository.CrudRepository;

/**
 * @author mallen
 * @date 4/18/19
 */
public interface SimpleRepository extends CrudRepository<MallenUser, String> {

}
