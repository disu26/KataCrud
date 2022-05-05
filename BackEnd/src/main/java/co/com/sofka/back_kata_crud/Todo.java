package co.com.sofka.back_kata_crud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entidad todo.
 *
 * @version 1.0.0 2022-05-04
 * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
 * @since 1.0.0
 */
@Entity
public final class Todo {
    /**
     * Id de la entidad todo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Campo nombre de la entidad todo.
     */
    private String name;

    /**
     * Campo que indica si el campo se ha completado o no.
     */
    private boolean isCompleted;

    /**
     * Método para obtener el id del todo.
     *
     * @return id del todo.
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     * @since 1.0.0
     */
    public Long getId() {
        return id;
    }

    /**
     * Método para asignar un id al todo.
     *
     * @param id valor que se desea asignar.
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     * @since 1.0.0
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método para obtener el nombre del todo.
     *
     * @return nombre del todo.
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     * @since 1.0.0
     */
    public String getName() {
        return name;
    }

    /**
     * Método para asignar un nombre al todo.
     *
     * @param name valor que se desea asignar
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     * @since 1.0.0
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método para obtener el valor del campo completed.
     *
     * @return boolean que indica si el campo está completado o no.
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     * @since 1.0.0
     */
    public boolean getCompleted() {
        return isCompleted;
    }

    /**
     * Método para asignar un valor al campo completed.
     *
     * @param completed valor que se le desea dar
     *
     * @author Dímar Andrey Suárez Hidalgo <dimar260212@gmail.com>
     * @since 1.0.0
     */
    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }
}
