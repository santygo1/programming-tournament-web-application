import React from 'react';
import classes from "./TaskPreview.module.css";
import {TrackValues} from "../../../components/TrackTypeSelector/TrackValues.js";
import { useNavigate } from "react-router-dom";

const TaskPreview = ({task}) => {
    const navigator = useNavigate()
    return (
        <div className={classes.TaskPreview} onClick={() => navigator('/tasks/' + task.id)}>
            <span style={{
                backgroundColor: task.category === null ? "gray" : TrackValues[task.category].color
            }} className={classes.tag}
            >{task.category === null ? "Вне категории" : TrackValues[task.category].text}</span>
            <div className={classes.title}>{task.title}</div>
        </div>
    );
};

export default TaskPreview;