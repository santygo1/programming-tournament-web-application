import React from 'react';
import classes from "./TrackTypeSelector.module.css";
import {TrackValues} from "./TrackValues.js";

const TrackTypeSelector = ({value, onSelect}) => {

    function handleSelect(trackName) {
        onSelect(trackName);
    }

    return (
        <div className={classes.TrackTypeSelector}>
            {Object.keys(TrackValues).map((key) =>
                <div key={key} className={classes.track} onClick={() => handleSelect(key)}>
                    <img style={value === key ? {borderColor: TrackValues[key].color} : {}} src={TrackValues[key].image}
                         className={value === key ? classes.selected : ""}/>
                    {value === key && <p>{TrackValues[key].text}</p>}
                </div>
            )}
        </div>
    );
};

export default TrackTypeSelector;