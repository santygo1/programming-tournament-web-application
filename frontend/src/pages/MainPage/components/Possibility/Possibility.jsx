import React from 'react';
import classes from "./Possibility.module.css";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

const Possibility = ({icon, text}) => {
    return (
        <div className={classes.Possibility}>
            <div className={classes.icon}>
                {icon}
            </div>
            <h4>{text}</h4>
        </div>
    );
};

export default Possibility;