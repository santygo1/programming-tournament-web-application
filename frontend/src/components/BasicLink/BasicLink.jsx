import React from 'react';
import classes from "./BasicLink.module.css";
import {faArrowUpRightFromSquare} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {Link} from "react-router-dom";
const BasicLink = ({title, href}) => {
    return (
        <Link to={href} className={classes.BasicLink} href={href}>
            {title}
            <FontAwesomeIcon icon={faArrowUpRightFromSquare} />
        </Link>
    );
};

export default BasicLink;