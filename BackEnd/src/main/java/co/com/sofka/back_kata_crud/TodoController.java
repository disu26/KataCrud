package co.com.sofka.back_kata_crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para los todos.
 *
 * @version 1.0.0 2022-05-04
 * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
 * @since 1.0.0
 */
@RestController
@CrossOrigin(origins = "*",  methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.PATCH})
public final class TodoController {

    /**
     * Servicio para el manejo del todo
     */
    @Autowired
    private TodoService service;

    /**
     * Devuelve un listado con los todos creados.
     *
     * @return Objeto iterable con los todos.
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     * @since 1.0.0
     */
    @GetMapping(value = "api/todos")
    public Iterable<Todo> list(){
        return service.list();
    }

    /**
     * Creación de un nuevo todo.
     *
     * @param todo Objeto todo que se desea almacenar.
     * @return Todo que se creó.
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     * @since 1.0.0
     */
    @PostMapping(value = "api/todos")
    public Todo save(@RequestBody Todo todo){
        return service.save(todo);
    }

    /**
     * Actualizar un todo.
     *
     * @param todo que se desea actualizar
     * @return Todo con la nueva información
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     * @since 1.0.0
     */
    @PutMapping(value = "api/todos")
    public Todo update(@RequestBody Todo todo){
        if (todo.getId() != null){
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    /**
     * Actualizar el campo completed de un todo.
     *
     * @param todo que se desea actualizar
     * @return Todo con la nueva información
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     * @since 1.0.0
     */
    @PutMapping(value = "api/todosComplete")
    public Todo updateComplete(@RequestBody Todo todo){
        if (todo.getId() != null){
            todo.setCompleted(true);
            return service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    /**
     * Elimina un todo.
     *
     * @param id del todo que se desea eliminar
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     * @since 1.0.0
     */
    @DeleteMapping(value = "api/{id}/todos")
    public void eliminar(@PathVariable("id") Long id){
        service.eliminar(id);
    }

    /**
     * Retorna un todo en base a su id.
     *
     * @param id del todo que se desea obtener
     * @return todo encontrado por su id
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     * @since 1.0.0
     */
    @GetMapping(value = "api/{id}/todos")
    public Todo get(@PathVariable("id") Long id){
        return service.get(id);
    }
}
