package co.com.sofka.back_kata_crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para el todo.
 *
 * @version 1.0.0 2022-05-04
 * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
 * @since 1.0.0
 */
@Service
public final class TodoService {

    /**
     * Repositiorio del todo.
     */
    @Autowired
    private TodoRepository repository;

    /**
     * Retorna los todos que hay en el sistema
     *
     * @return Iterable con todos los objetos que hay en el sistema.
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     * @since 1.0.0
     */
    public Iterable<Todo> list(){
        return repository.findAll();
    }

    /**
     * Método para guardar un todo.
     *
     * @param todo que se desea guardar
     * @return todo guardado
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     * @since 1.0.0
     */
    public Todo save(Todo todo){
        return repository.save(todo);
    }

    /**
     * Eimina un todo en base a su id.
     *
     * @param id que se desea eliminar.
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     * @since 1.0.0
     */
    public void eliminar(Long id){
        repository.delete(get(id));
    }

    /**
     * Método para retornar un todo en base a su id.
     *
     * @param id del todo que se desea buscar.
     * @return Todo que se obtiene.
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     * @since 1.0.0
     */
    public Todo get(Long id){
        return repository.findById(id).orElseThrow();
    }
}
