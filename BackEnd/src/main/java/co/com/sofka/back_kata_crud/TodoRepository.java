package co.com.sofka.back_kata_crud;

import org.springframework.data.repository.CrudRepository;

/**
 * Repositorio para el todo.
 *
 * @version 1.0.0 2022-05-04
 * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
 * @since 1.0.0
 */
public interface TodoRepository extends CrudRepository<Todo, Long> {
}
