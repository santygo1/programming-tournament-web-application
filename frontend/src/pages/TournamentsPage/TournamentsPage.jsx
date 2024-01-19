import React, {useEffect, useState} from 'react';
import classes from "./TournamentsPage.module.css";
import {Button, Container, Row} from "react-bootstrap";
import TrackTypeSelector from "../../components/TrackTypeSelector/TrackTypeSelector.jsx";
import PropertySelector from "../../components/Filter/PropertySelector.jsx";
import {DefaultFilterValues} from "../../components/Filter/FilterValues.js";
import {DefaultSortValues} from "../../components/Filter/SortValues.js";
import useFetch from "../../hooks/useFetch.js";
import TournamentService from "../../api/TournamentService.js";
import TournamentPreview from "./TournamentPreview/TournamentPreview.jsx";
import UserService from "../../api/UserService.js";
import {CAN_CREATE_TOURNAMENTS} from "../../api/auth.js";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faAdd, faEdit} from "@fortawesome/free-solid-svg-icons";

const TournamentsPage = (props) => {

    const [user, setUser] = useState(null);
    const [fetchUser, isUserLoading, userError] = useFetch(
        async () => {
            const user = await UserService.getById(localStorage.getItem("userId"));
            setUser(user);
        }
    );

    const [currentTrack, setCurrentTrack] = useState("ALL");
    const [currentFilter, setCurrentFilter] = useState("ALL")
    const [currentSort, setCurrentSort] = useState("NONE");

    const [tournaments, setTournaments] = useState([]);
    const [fetchTournaments, isTournamentsLoading, tournamentError] = useFetch(
        async () => {

            const tournaments = await TournamentService.getAll(currentTrack, currentFilter, currentSort);
            setTournaments(tournaments);
        }
    );

    useEffect(() => {
        setCurrentSort("NONE");
        setCurrentFilter("ALL");
    }, [currentTrack]);

    useEffect(() => {
        fetchUser();
        fetchTournaments();
    }, [currentTrack, currentFilter, currentSort]);

    return (
        <Container className={["Page", classes.TournamentsPage].join(" ")} style={{gap: "10px"}}>
            <Row className={classes.body}>
                <div className={classes.title}>
                    <h1>Соревнования</h1>
                    {(user && CAN_CREATE_TOURNAMENTS[user.role]) &&
                        <Button className={"button-with-icon"} variant={"outline-danger"}>Создать<FontAwesomeIcon icon={faAdd}/></Button>}
                </div>
                <TrackTypeSelector value={currentTrack} onSelect={(track) => setCurrentTrack(track)}/>
                <div className={classes.filter}>
                    <PropertySelector hintText={"Показать"} value={currentFilter}
                                      onFilter={(filter) => setCurrentFilter(filter)}
                                      filterValues={DefaultFilterValues}/>

                    <PropertySelector hintText={"Сортировать"} value={currentSort}
                                      onFilter={(sort) => setCurrentSort(sort)}
                                      filterValues={DefaultSortValues}/>
                </div>
            </Row>
            <Row className={classes.tournamentList}>
                {tournaments.length > 0 ? tournaments.map(t => <TournamentPreview key={t.id} tournament={t}/>) :
                    <div className={classes.nothing}>По вашему запросу ничего не найдено!</div>}
            </Row>
        </Container>
    );
};

export default TournamentsPage;