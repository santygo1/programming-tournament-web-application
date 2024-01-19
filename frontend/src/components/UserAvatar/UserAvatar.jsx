import React from 'react';
import classes from "./UserAvatar.module.css";
import {faUser} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

const UserAvatar = ({user}) => {
    return (
        <div className={classes.UserAvatar} >
            <span>{user.username}</span>
            <FontAwesomeIcon icon={faUser} size={"1x"} color={"white"}/>
        </div>
    );
};

export default UserAvatar;