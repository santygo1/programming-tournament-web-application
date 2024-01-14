import React from 'react';
import classes from "./BasicLink.module.css";
import {faArrowUpRightFromSquare} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
const BasicLink = ({title, href}) => {
    return (
        <a className={classes.BasicLink} href={href}>
            {title}
            <FontAwesomeIcon icon={faArrowUpRightFromSquare} />
        </a>
    );
};

export default BasicLink;