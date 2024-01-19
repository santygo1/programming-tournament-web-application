import React, {useEffect, useState} from 'react';
import classes from "./TournamentsPage.module.css";
import {Container, Row} from "react-bootstrap";
import TrackTypeSelector from "../../components/TrackTypeSelector/TrackTypeSelector.jsx";
import PropertySelector from "../../components/Filter/PropertySelector.jsx";
import {DefaultFilterValues} from "../../components/Filter/FilterValues.js";
import {DefaultSortValues} from "../../components/Filter/SortValues.js";
import useFetch from "../../hooks/useFetch.js";
import TournamentService from "../../api/TournamentService.js";
import TournamentPreview from "./TournamentPreview/TournamentPreview.jsx";

const TournamentsPage = (props) => {

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
        fetchTournaments();
    }, [currentTrack, currentFilter, currentSort]);

    return (
        <Container fluid className={["Page", classes.TournamentsPage].join(" ")} style={{gap: "10px"}}>
            <Row className={classes.body}>
                <h1>Соревнования</h1>
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