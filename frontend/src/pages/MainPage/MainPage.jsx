import React, {useEffect, useState} from 'react';
import classes from "./MainPage.module.css";
import {Col, Container, Image, Row} from "react-bootstrap";
import highload from "../../assets/highload.png"
import proc from "../../assets/proc.png"
import ListPreview from "./components/ListPreview/ListPreview.jsx";
import BasicLink from "../../components/BasicLink/BasicLink.jsx";
import {faLightbulb, faMedal, faTrophy} from "@fortawesome/free-solid-svg-icons";
import CardPreview from "./components/CardPreview/CardPreview.jsx";
import Achievement from "./components/Achievement.jsx";
import Possibility from "./components/Possibility/Possibility.jsx";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import Footer from "../../components/BasicLink/Footer/Footer.jsx";
import useFetch from "../../hooks/useFetch.js";
import TournamentService from "../../api/TournamentService.js";
import TaskService from "../../api/TaskService.js";

const MainPage = (props) => {

    const [tournaments, setTournaments] = useState([]);
    const [fetchTournaments, isTournamentsLoading, tournamentError] = useFetch(
        async () => {
            const tournaments = await TournamentService.getAll();
            setTournaments(tournaments);
        }
    );

    const [tasks, setTasks] = useState([])
    const [fetchTasks, isTasksLoading, taskError] = useFetch(
        async () => {
            const tasks = await TaskService.getAll();
            setTasks(tasks);
        }
    )

    useEffect(() => {
        fetchTournaments();
        fetchTasks();
    }, []);


    return (
        <>
            <Container fluid className={[classes.MainPage, "Page"].join(" ")}>
                <Row className={classes.welcome}>
                    <Col className={classes.info}>
                        <div>
                            <h1>all cups</h1>
                            <h3 className={"thin"}>IT-Соревнования для специалистов и начинающих</h3>
                        </div>
                        <p style={{width: "50%"}}>Решай креативные задачи, обменивайся опытом, открывай новые
                            направления, выигрывай ценные призы</p>
                    </Col>
                    <Col style={{display: "flex", alignItems: "center", justifyContent: "center"}}>
                        <Image src={highload} height={650} width={650}/>
                    </Col>
                </Row>

                <ListPreview title={"Ближайшие турниры"}
                             link={<BasicLink title={"ко всем соревнованиям"} href={"/tournaments"}/>}>
                    {tournaments.map((t) => <CardPreview key={t.id} data={t}/>).slice(0, 4)}
                </ListPreview>


                <Row>
                    <Container>
                        <h1 style={{color: "#b066f0"}}>Возможности платформы</h1>
                        <Row style={{marginTop: "120px"}}>
                            <Col style={{display: "flex", alignItems: "center", justifyContent: "center"}}>
                                <Image src={proc} height={500} width={500}/>
                            </Col>
                            <Col className={classes.achievments}>
                                <Achievement title={"15"} text={"ежегодных соревнований"}/>
                                <Achievement title={"300 тыс. +"} text={"участников на платформе"}/>
                                <Achievement title={"351 тыс."} text={"Загруженных решений"}/>
                            </Col>
                        </Row>

                        <div className={classes.possibilities}>
                            <Possibility
                                icon={<FontAwesomeIcon icon={faLightbulb} color={"#b066f0"} size={"2xl"}/>}
                                text={"Творческие задачи по направлениям AI, HighLoad, ML, Спортивное программирование"}/>
                            <Possibility
                                icon={<FontAwesomeIcon icon={faMedal} color={"#eb4d86"} size={"2xl"}/>}
                                text={"Награда за победы, сертификаты, возможность трудоустройства в компании"}/>
                            <Possibility
                                icon={<FontAwesomeIcon icon={faTrophy} color={"#50c3a0"} size={"2xl"}/>}
                                text={"ТКрупные соревнования от топовых компаний и олимпиады от ведущих вузов"}/>
                        </div>
                    </Container>
                </Row>

                <ListPreview title={"Песочница"} link={<BasicLink title={"в песочницу"} href={"/tasks"}/>}>
                    {tasks.map(t => <CardPreview key={t.id} data={t}/>).slice(0, 3)}
                </ListPreview>
                <Footer/>
            </Container>
        </>
    );
};

export default MainPage;