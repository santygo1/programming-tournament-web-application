import React from 'react';
import classes from "./PropertySelector.module.css";

const PropertySelector = ({hintText, value, onFilter, filterValues}) => {

    return (
        <div className={classes.PropertySelector}>
            <p className={classes.hint}>{hintText}:</p>
            {Object.keys(filterValues).map(key =>
                <p key={key}
                   className={key === value ? [classes.key, classes.active].join(" ") : classes.key}
                   onClick={() => onFilter(key)}>
                    {filterValues[key]}
                </p>
            )}
        </div>
    );
};

export default PropertySelector;