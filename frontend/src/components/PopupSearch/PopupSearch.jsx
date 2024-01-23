import React, {useRef, useState} from 'react';
import classes from "./PopupSearch.module.css";
import {faSearch} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

const PopupSearch = ({placeholder = "Поиск", value, onChange}) => {

    const inputRef = useRef(null);

    function handleSearchButton() {
        inputRef.current.focus();
    }

    let iconStyles = [classes.icon];
    if (value.length > 0) {
        iconStyles.push(classes.withInput)
    }
    iconStyles = iconStyles.join(" ")

    return (
        <div className={classes.PopupSearch}>
            <input placeholder={placeholder} className={classes.search}
                   ref={inputRef}
                   type="text" onChange={(e) => onChange(e.target.value)}/>
            <FontAwesomeIcon className={iconStyles} icon={faSearch} onClick={handleSearchButton}/>
        </div>
    );
};

export default PopupSearch;