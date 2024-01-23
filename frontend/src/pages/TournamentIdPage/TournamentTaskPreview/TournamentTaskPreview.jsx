import React from 'react';
import classes from "./TaskPreview.module.css";
import {Col, Row} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faAngleRight, faClock, faMemory} from "@fortawesome/free-solid-svg-icons";
import {useNavigate} from "react-router-dom";

const TournamentTaskPreview = ({task}) => {
    const navigator = useNavigate();

    return (
        <Row className={classes.TaskPreview} onClick={() => navigator(`/tasks/${task.id}`)}>
            <Col className={classes.title}>{task.title}</Col>
            <Col md={1} className={classes.requirements}>
                <FontAwesomeIcon icon={faClock} color={"#5c86f0"}/>
                <b>{task.timeRequirementsInMinutes > 0 ? task.timeRequirementsInMinutes: "Отсутствуют"}</b></Col>
            <Col md={1} className={classes.requirements}>
                <FontAwesomeIcon icon={faMemory} color={"#5c86f0"}/>
                <b>{task.memoryRequirementsInMb > 0 ? task.memoryRequirementsInMb: "Отсутствуют"}</b></Col>
            <Col md={1} className={classes.arrowCell}><FontAwesomeIcon icon={faAngleRight} color={"white"} /></Col>
        </Row>
    );
};

export default TournamentTaskPreview;