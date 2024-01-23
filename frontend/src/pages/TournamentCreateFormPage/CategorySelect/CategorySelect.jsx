import React from 'react';
import classes from "./CategorySelect.module.css";
import {Form} from "react-bootstrap";

const CategorySelect = (props) => {
    return (
        <Form.Check
            className={classes.CategorySelect}
            style={{
                backgroundImage: props.image,
            }}
            type={"radio"}
            checked={props.checked}
            name={props.name}
            onChange={props.onChange}
            label={<img onClick={props.onChange} src={props.image} title={props.hint}/>}
        ></Form.Check>
    );
};

export default CategorySelect;