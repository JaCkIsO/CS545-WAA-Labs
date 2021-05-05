import React, { useState, useEffect } from 'react';
import { Student } from '../Student/Student';

export const Dashboard = () => {

    const [students, setStudents] = useState([
        {id: 123, name: "Bob", major: "CS"},
        {id: 456, name: "Andy", major: "CS"},
        {id: 789, name: "Charles", major: "CS"}]);

    const [inputValue,setInputValue] = useState("");

    const handleClick = () => {
        const studentsCopy = [...students];
        studentsCopy[0].name = inputValue;
        setStudents(studentsCopy);
    }

    const handleChange = (e) =>{
        setInputValue(e.target.value);
    }
    return ( 
        <div>
            <h1>Hello from Dashboard!</h1> 
            {students.map(student => <Student key={student.id} id={student.id} name={student.name} major={student.major} />)}
            <input value={inputValue}  onChange={handleChange}/><button onClick={ () =>{  handleClick();}}>Change Name</button>
        </div> 
    );
};
