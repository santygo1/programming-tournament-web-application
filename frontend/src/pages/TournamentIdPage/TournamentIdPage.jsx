import React, {useEffect, useState} from 'react';
import classes from "./TournamentIdPage.module.css";
import {Container, Row} from "react-bootstrap";
import {useParams} from "react-router-dom";
import useFetch from "../../hooks/useFetch.js";
import TaskService from "../../api/TaskService.js";
import UserService from "../../api/UserService.js";
import TournamentService from "../../api/TournamentService.js";
import TournamentPreview from "../TournamentsPage/TournamentPreview/TournamentPreview.jsx";
import TournamentTaskPreview from "./TournamentTaskPreview/TournamentTaskPreview.jsx";

const TournamentIdPage = () => {
    const params = useParams();

    const [tournament, setTournament] = useState(null);
    const [tasks, setTasks] = useState([])

    const [fetchTournamentAndTasks, isLoading, error] = useFetch(
        async () => {
            const tournament = await TournamentService.getById(params.id);
            setTournament(tournament);
            const tasks = await TaskService.getTournamentTasks(params.id);
            setTasks(tasks);
        }
    );

    useEffect(() => {
        fetchTournamentAndTasks();
    }, []);

    return (
        <Container fluid className={["Page", classes.TournamentIdPage].join(" ")} style={{gap: "40px"}}>
            {tournament &&
                <>
                    <TournamentPreview tournament={tournament} clickable={false}/>
                    {tasks.length > 0 ?
                        <Row className={classes.capsule}>
                            <h4 style={{marginBottom: "20px"}} >Задачи</h4>
                            <div className={classes.tasksList}>
                                {tasks.map(task => <TournamentTaskPreview key={task.id}task={task} />)}
                            </div>
                        </Row>:
                        <Row className={classes.capsule}> На данный момент задания отсутствуют!</Row>
                    }
                </>}
        </Container>
    );
};

export default TournamentIdPage;