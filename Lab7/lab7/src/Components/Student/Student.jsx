import React from 'react';
import "./Student.css"
export const Student = (props) => {

    return(
        <div className="student">
            <div>Student</div>
            <div>ID: {props.id}</div>
            <div>Name: {props.name}</div>
            <div>Major: {props.major}</div>
        </div>
    )
    
};
