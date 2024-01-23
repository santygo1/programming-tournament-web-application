import React, {useEffect, useState} from 'react';
import classes from "./TasksPage.module.css";
import {Container, Row} from "react-bootstrap";
import TrackTypeSelector from "../../components/TrackTypeSelector/TrackTypeSelector.jsx";
import PropertySelector from "../../components/Filter/PropertySelector.jsx";
import {DefaultFilterValues} from "../../components/Filter/FilterValues.js";
import {DefaultSortValues} from "../../components/Filter/SortValues.js";
import TournamentPreview from "../TournamentsPage/TournamentPreview/TournamentPreview.jsx";
import useFetch from "../../hooks/useFetch.js";
import TournamentService from "../../api/TournamentService.js";
import TaskService from "../../api/TaskService.js";
import TaskPreview from "./TaskPreview/TaskPreview.jsx";

const TasksPage = (props) => {

    const [currentTrack, setCurrentTrack] = useState("ALL");
    const [currentSort, setCurrentSort] = useState("NONE");

    const [tasks, setTasks] = useState([]);
    const [fetchTasks, isTasksLoading, tasksError] = useFetch(
        async () => {

            const tasks = await TaskService.getAll(currentTrack, currentSort);
            setTasks(tasks);
        }
    );
    useEffect(() => {
        setCurrentSort("NONE");
    }, [currentTrack]);

    useEffect(() => {
        fetchTasks();
    }, [currentTrack, currentSort]);



    return (
        <Container className={["Page", classes.TasksPage].join(" ")} style={{gap: "10px"}}>
            <Row className={classes.body}>
                <h1 className={"page-title"}>Песочница</h1>
                <TrackTypeSelector value={currentTrack} onSelect={(track) => setCurrentTrack(track)}/>
                <div className={classes.filter}>
                    <PropertySelector hintText={"Сортировать"} value={currentSort}
                                      onFilter={(sort) => setCurrentSort(sort)}
                                      filterValues={DefaultSortValues}/>
                </div>
            </Row>
            <Row>
                <Container className={classes.taskGrid}>
                    {tasks.length > 0 ? tasks.map(t => <TaskPreview key={t.id} task={t}/>) :
                        <div className={classes.nothing}>По вашему запросу ничего не найдено!</div>}
                </Container>
            </Row>
        </Container>
    );
};

export default TasksPage;