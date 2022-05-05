import React, { useContext, useEffect } from "react";
import { HOST_API } from "../App";
import { Store } from "../App";

const List = () => {
  const { dispatch, state } = useContext(Store);

  useEffect(() => {
    fetch(HOST_API + "/todos")
      .then((response) => response.json())
      .then((list) => {
        dispatch({ type: "update-list", list });
      });
  }, [state.list.length, dispatch]);

  const onDelete = (id) => {
    fetch(HOST_API + "/" + id + "/todos", {
      method: "DELETE",
    }).then((list) => {
      dispatch({ type: "delete-item", id });
    });
  };

  const onComplete = (todo) => {
    const request = {
      name: todo.name,
      id: todo.id,
      isCompleted: true,
    };

    fetch(HOST_API + "/todosComplete", {
      method: "PUT",
      mode: "cors",
      body: JSON.stringify(request),
      headers: {
        "Content-Type": "application/json",
      },
      credentials: "same-origin",
    })
      .then((response) => {
        response.json();
      })
      .then(() => {
        dispatch({ type: "update-item", item: request });
      });
  };

  const onEdit = (todo) => {
    dispatch({ type: "edit-item", item: todo });
  };

  return (
    <div className="container mt-5">
      <table className="table">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">Nombre</th>
            <th scope="col">¿Está completado?</th>
          </tr>
        </thead>
        <tbody>
          {state.list.map((todo) => {
            return (
              <tr key={todo.id}>
                <td>{todo.id}</td>
                <td>{todo.name}</td>
                <td>{todo.isCompleted === true ? "SI" : "NO"}</td>
                <td>
                  <button
                    className="btn btn-danger"
                    onClick={() => onDelete(todo.id)}
                  >
                    Eliminar
                  </button>
                </td>
                <td>
                  <button
                    className="btn btn-warning"
                    onClick={() => onEdit(todo)}
                  >
                    Editar
                  </button>
                </td>
                <td>
                  <button
                    className="btn btn-success"
                    onClick={() => onComplete(todo)}
                  >
                    Completar
                  </button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default List;
