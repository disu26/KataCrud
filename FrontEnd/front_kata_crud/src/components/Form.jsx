import React, { useState, useContext, useRef } from "react";
import { HOST_API } from "../App";
import { Store } from "../App";

/**
 * Componente formulario donde se ingresarán los todos.
 * @returns 
 */
const Form = () => {
  const formRef = useRef(null);

  const {
    dispatch,
    state: { item },
  } = useContext(Store);

  const [state, setState] = useState(item);

  /**
   * Método para añadir un todo.
   * @param {*} event 
   */
  const onAdd = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: null,
      isCompleted: false,
    };

    fetch(HOST_API + "/todos", {
      method: "POST",
      mode: "cors",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
      credentials: "same-origin",
    })
      .then((response) => response.json())
      .then((todo) => {
        dispatch({ type: "add-item", item: todo });
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  /**
   * Editar un todo.
   * @param {*} event 
   */
  const onEdit = (event) => {
    event.preventDefault();

    const request = {
      name: state.name,
      id: item.id,
      isCompleted: item.isCompleted,
    };

    fetch(HOST_API + "/todos", {
      method: "PUT",
      mode: "cors",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
      credentials: "same-origin",
    })
      .then((response) => response.json())
      .then((todo) => {
        dispatch({ type: "update-item", item: todo });
        setState({ name: "" });
        formRef.current.reset();
      });
  };

  return (
    <div className="container mt-5">
      <form ref={formRef}>
        <div className="form-group">
          <input
            className="form-control"
            type="text"
            name="name"
            defaultValue={item.name}
            onChange={(event) => {
              setState({ ...state, name: event.target.value });
            }}
          />
          <small className="form-text text-muted">Ingrese un todo</small>
        </div>
        {item.id && (
          <button className="btn btn-primary" onClick={onEdit}>
            Actualizar
          </button>
        )}
        {!item.id && (
          <button className="btn btn-primary" onClick={onAdd}>
            Agregar
          </button>
        )}
      </form>
    </div>
  );
};

export default Form;
