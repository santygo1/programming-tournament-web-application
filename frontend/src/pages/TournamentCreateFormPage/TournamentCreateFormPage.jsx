import React, {useEffect, useState} from 'react';
import classes from "./TournamentCreateForm.module.css";
import {Button, Col, Container, Form, Row} from "react-bootstrap";
import {TrackValues} from "../../components/TrackTypeSelector/TrackValues.js";
import CategoryRadio from "./CategorySelect/CategorySelect.jsx";
import TwoSideTaskMultiSelect from "./TwoSideTaskMultiSelect/TwoSideTaskMultiSelect.jsx";
import useFetch from "../../hooks/useFetch.js";
import TaskService from "../../api/TaskService.js";
import TournamentService from "../../api/TournamentService.js";
import {useNavigate} from "react-router-dom";

function convertToTournament(inputFields, category, tasks){
    return {
        ...inputFields,
        category: category,
        tasks: tasks.map(s => s.id)
    }
}

const TournamentCreateFormPage = (props) => {

    const navigate = useNavigate();

    const [selectedCategory, setSelectedCategory] = useState("EXTREME");
    const [availableTasks, setAvailableTasks] = useState([]);
    const [valid, setValid] = useState(null);

    const [fetchTasks, isLoading, error] = useFetch(
        async () => {
            const tasks = await TaskService.getAll(selectedCategory);
            setAvailableTasks(tasks);
        }
    );

    const [inputFields, setInputFields] = useState({
        title: "",
        startDate: "",
        finishDate: "",
        text: ""
    });

    useEffect(() => {
        fetchTasks();
    }, [selectedCategory]);

    const [selectedTasks, setSelectedTasks] = useState([])

    function changeCategory(category) {
        setSelectedCategory(category);
        setSelectedTasks([]);
    }

    function handleAccept(e){
        e.preventDefault();
        if (selectedTasks.length > 0){
            setValid(true);

            const tournament = convertToTournament(inputFields, selectedCategory, selectedTasks);
            TournamentService
                .createTournament(tournament)
                .then(resp => navigate(`/tournaments/${resp.id}`));
        }else {
            setValid(false);
        }
    }

    return (
        <Form onSubmit={handleAccept}>
            <Container className={["Page", classes.TournamentCreateForm].join(" ")} style={{gap: "20px"}}>
                <Row>
                    <h3 className={"page-title"}>Создание турнира</h3>
                </Row>
                <Row className={"capsule"}>
                    <Col md={6}>
                        <p className={classes.groupTitle}>Основная информация</p>
                        <Form.Group className="mb-3" controlId="title">
                            <Form.Label>Название</Form.Label>
                            <Form.Control type="text"
                                          value={inputFields.title}
                                          onChange={(e) => setInputFields({...inputFields, title: e.target.value})}
                                          placeholder="Турнир" required/>
                        </Form.Group>

                        <div className={classes.dates}>
                            <Form.Group className="mb-3" controlId="startDate">
                                <Form.Label>Дата начала</Form.Label>
                                <Form.Control
                                    value={inputFields.start_date}
                                    onChange={(e) => setInputFields({...inputFields, startDate: e.target.value})}
                                    type="datetime-local" required/>
                            </Form.Group>
                            <Form.Group className="mb-3" controlId="finishDate">
                                <Form.Label>Дата окончания</Form.Label>
                                <Form.Control
                                    value={inputFields.finish_date}
                                    onChange={(e) => setInputFields({...inputFields, finishDate: e.target.value})}
                                    type="datetime-local"
                                    min={inputFields.start_date}
                                    required/>
                            </Form.Group>
                        </div>

                        <Form.Group className="mb-3" controlId="description">
                            <Form.Label>Описание</Form.Label>
                            <Form.Control
                                value={inputFields.description}
                                onChange={(e) => setInputFields({...inputFields, text: e.target.value})}
                                as="textarea" rows={9}/>
                        </Form.Group>

                        <Form.Group className="mb-3">
                            <Form.Label style={{marginBottom: "20px"}}>
                                Категория:
                                <span style={{
                                    color: TrackValues[selectedCategory].color,
                                    marginLeft: "10px"
                                }}>
                            {TrackValues[selectedCategory].text}
                            </span>
                            </Form.Label>
                            <div className={classes.radios}>
                                {Object.keys(TrackValues).slice(1).map(t =>
                                    <CategoryRadio
                                        key={`select-${t}`}
                                        type={"radio"}
                                        name={"category"}
                                        image={TrackValues[t].image}
                                        hint={TrackValues[t].text}
                                        color={TrackValues[t].color}
                                        checked={t === selectedCategory}
                                        onChange={() => changeCategory(t)}
                                    />
                                )}
                            </div>
                        </Form.Group>
                    </Col>
                </Row>
                <Row className={"capsule"}>
                    <p className={classes.groupTitle}>Задачи</p>
                    {valid === false && <div className={classes.error}>
                        Выберите хотя бы одну задачу.
                    </div>}
                    <TwoSideTaskMultiSelect selected={selectedTasks}
                                            onChangeSelected={(v) => setSelectedTasks(v)}
                                            selectedLimit={5}
                                            available={availableTasks}
                    />
                </Row>

                <Row>
                    <div className={classes.createButton}><Button type={"submit"}>Добавить</Button></div>
                </Row>
                <Row>
                    <h3></h3>
                </Row>
            </Container>
        </Form>
    );
};

export default TournamentCreateFormPage;