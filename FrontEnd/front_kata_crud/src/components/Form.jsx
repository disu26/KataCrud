import React, { useState, useContext, useRef} from 'react'
import { HOST_API } from '../App';
import { Store } from '../App';

const Form = () => {
    const formRef = useRef(null);

    const{ dispatch, state: {item}} = useContext(Store);
  
    const [state, setState] = useState(item);
  
    const onAdd = (event) => {
      event.preventDefault();
  
      const request = {
        name: state.name,
        id: null,
        isCompleted: false
      };
  
      fetch(HOST_API+"/todos", {
        method: "POST",
        mode: 'cors',
        body: JSON.stringify(request),
        headers: {
          'Content-Type': 'application/json'
        },
        credentials: 'same-origin'
      })
      .then(response => response.json())
      .then((todo) => {
        dispatch({ type: "add-item", item: todo});
        setState({ name: ""});
        formRef.current.reset();
      });
    }
  
    const onEdit = (event) => {
      event.preventDefault();
  
      const request = {
        name: state.name,
        id: item.id,
        isCompleted: item.isCompleted
      };
  
      fetch(HOST_API+"/todos", {
        method: "PUT",
        mode: 'cors',
        body: JSON.stringify(request),
        headers: {
          'Content-Type': 'application/json'
        },
        credentials: 'same-origin'
      })
      .then(response => response.json())
      .then((todo) => {
        dispatch({ type: "update-item", item: todo});
        setState({ name: ""});
        formRef.current.reset();
      });
    }
  
    return <form ref={formRef}>
      <input 
        type='text'
        name='name'
        defaultValue={item.name}
        onChange={(event) => {
          setState({ ...state, name: event.target.value })
        }}
      />
      {
        item.id && <button onClick={onEdit}>Actualizar</button>
      }
      {
        !item.id && <button onClick={onAdd}>Agregar</button>
      }
    </form>
}

export default Form