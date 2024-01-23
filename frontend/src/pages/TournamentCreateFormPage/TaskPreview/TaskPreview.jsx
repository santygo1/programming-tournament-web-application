import React from 'react';
import classes from "./TaskPreview.module.css";
import {Accordion, Col, Container, Row} from "react-bootstrap";
import {TrackValues} from "../../../components/TrackTypeSelector/TrackValues.js";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faClock, faMemory} from "@fortawesome/free-solid-svg-icons";

const TaskPreview = ({task}) => {
    return (
        <Container fluid className={["Page", classes.TaskPreview].join(" ")}>
            <Row className={classes.gap}>
                <Row className={[classes.head, classes.capsule].join(" ")}>
                    <div
                        style={{
                            backgroundColor: task.category ? TrackValues[task.category].color : "gray"
                        }}
                        className={classes.tag}
                    >{task.category ? TrackValues[task.category].text : "Вне категории"}</div>
                    <Row>
                        <Col>
                            <h2>{task.title}</h2>
                            <p>Всего тестов: {task.tests ? task.tests.length : 0}</p>
                        </Col>
                    </Row>
                </Row>
                <Row className={classes.gap}>
                    <Col>
                        <Row className={classes.gap}>
                            <Row className={classes.capsule}>
                                <div className={classes.requirements}>
                                    <div className={classes.title}>Ограничения</div>
                                    <div>
                                        <div>по времени</div>
                                        <FontAwesomeIcon icon={faClock} color={"#5c86f0"}/>
                                        <b>{task.timeRequirementsInMinutes == 0 ? "Отсутствуют" : task.timeRequirementsInMinutes + " мин."}</b>
                                    </div>
                                    <div>
                                        <div>по памяти</div>
                                        <FontAwesomeIcon icon={faMemory} color={"#5c86f0"}/>
                                        <b>{task.memoryRequirementsInMb == 0 ? "Отсутствуют" : task.memoryRequirementsInMb + "Мб"}</b>
                                    </div>
                                </div>
                            </Row>
                            <Row className={classes.capsule}>
                                <h5>Описание</h5>
                                <div>{task.text}</div>
                            </Row>
                        </Row>
                    </Col>

                    <Col>
                        <Row className={classes.gap}>
                            <Row className={classes.capsule}>
                                <h5>Формат входных данных</h5>
                                <div>{task.inputDataFormat}</div>
                            </Row>
                            <Row className={classes.capsule}>
                                <h5>Формат выходных данных</h5>
                                <div>{task.outputDataFormat}</div>
                            </Row>
                            {(task.tests && task.tests.length > 0) && <Row className={classes.capsule}>
                                {
                                    task.tests.map((test, index) =>
                                        <Accordion key={test.id}>
                                            <Accordion.Item eventKey={index}>
                                                <Accordion.Header>Тест #{index + 1}</Accordion.Header>
                                                <Accordion.Body>
                                                    <Container>
                                                        <Row>
                                                            <Col>
                                                                <b>Входные данные</b>
                                                            </Col>
                                                            <Col>
                                                                <b>Выходые данные</b>
                                                            </Col>
                                                        </Row>
                                                        <Row>
                                                            <Col>
                                                                {test.input}
                                                            </Col>
                                                            <Col>
                                                                {test.output}
                                                            </Col>
                                                        </Row>
                                                    </Container>
                                                </Accordion.Body>
                                            </Accordion.Item>
                                        </Accordion>)
                                }
                            </Row>
                            }
                        </Row>

                    </Col>
                </Row>
            </Row>
        </Container>
    );
};

export default TaskPreview;