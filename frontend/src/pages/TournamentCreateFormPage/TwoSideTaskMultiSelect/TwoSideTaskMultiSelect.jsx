import React, {useEffect, useState} from 'react';
import classes from "./TwoSideTaskMultiSelect.module.css";
import {Button, CloseButton, Col, Modal, Offcanvas, Row} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faEye} from "@fortawesome/free-solid-svg-icons";
import TaskPreview from "../TaskPreview/TaskPreview.jsx";
import PopupSearch from "../../../components/PopupSearch/PopupSearch.jsx";

const ModalTaskPreview = ({task, show, onClickHide}) => {
    return (
        <Modal show={show} fullscreen={true} onHide={onClickHide}>
            <Modal.Header closeButton closeVariant={"white"}>
                <Modal.Title>{task.title}</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <TaskPreview task={task}/>
            </Modal.Body>
        </Modal>
    )
}

const TwoSideTaskMultiSelect = ({selected, onChangeSelected, available}) => {

    const [availableFilter, setAvailableFilter] = useState("")
    const [availableList, setAvailableList] = useState([]);

    const [currentPreview, setCurrentPreview] = useState({});

    const [show, setShow] = useState(false);
    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    useEffect(() => {
        setAvailableList(available)
    }, [available]);

    function handleClickAvailable(value) {
        // добавление выбранного
        setAvailableList(availableList.filter(v => v !== value));
        onChangeSelected([...selected, value]);
    }

    function handleClickSelected(value) {
        setAvailableList([...availableList, value])
        onChangeSelected(selected.filter(s => s !== value))
    }

    function clearSelected() {
        onChangeSelected([]);
        setAvailableList(available)
    }

    function addAllAvailable() {
        onChangeSelected([...available]);
        setAvailableList([])
    }

    function handleFilter(filterValue) {
        setAvailableFilter(filterValue);
        setAvailableList(available.filter(v => !selected.includes(v) && v.title.toUpperCase().includes(filterValue.toUpperCase())));
    }

    return (
        <Row className={classes.TwoSideMultiSelect}>
            <Col className={classes.list}>
                <p className={classes.title}
                >Выбранные</p>
                {selected.length > 0 ?
                    selected.map(s =>
                        <div key={"selected-" + s.id} className={classes.listItem} onClick={() => handleClickSelected(s)}>
                            {s.title}
                            <FontAwesomeIcon className={classes.previewButton} icon={faEye} onClick={(e) => {
                                setCurrentPreview(s);
                                handleShow();
                                e.stopPropagation();
                            }}/>
                        </div>) : <div className={classes.hint}>Вы еще не добавили ни одного задания для турнира.</div>}
            </Col>
            <Col md={1} className={classes.buttons}>
                <Button disabled={selected.length === 0}
                        variant={"outline-success"} onClick={clearSelected}> >>
                </Button>
                <Button disabled={availableList.length === 0}
                        variant={"outline-success"} onClick={addAllAvailable}>{"<<"}
                </Button>
            </Col>
            <Col className={classes.list}>
                <div className={classes.search}>
                    <p className={classes.title}>Доступные</p>
                    <PopupSearch value={availableFilter} onChange={handleFilter}/>
                </div>
                {availableList.length > 0 ?
                    availableList.map(s =>
                        <div key={"available-" + s.id} className={classes.listItem} onClick={() => handleClickAvailable(s)}>
                            {s.title}
                            <FontAwesomeIcon className={classes.previewButton} icon={faEye} onClick={(e) => {
                                setCurrentPreview(s);
                                handleShow();
                                e.stopPropagation();
                            }}/>
                        </div>
                    ) :
                    <div className={classes.hint}>Не нашли нужные задачи? <a href={"#newTask"}>Создайте новую задачу</a>
                    </div>
                }
            </Col>

            <ModalTaskPreview task={currentPreview} show={show} onClickHide={handleClose}/>
        </Row>
    );
};

export default TwoSideTaskMultiSelect;