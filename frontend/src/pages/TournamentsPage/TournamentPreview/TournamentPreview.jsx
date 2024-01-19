import React from 'react';
import classes from "./TournamentPreview.module.css";
import {TrackValues} from "../../../components/TrackTypeSelector/TrackValues.js";
import {Link} from "react-router-dom";


//backgrounds
import defaultImg from '../../../assets/trackBackground/banner_allcups4.png'
import extremeImg from '../../../assets/trackBackground/Untitled_n8IYy8f.jpg'
import mlImg from '../../../assets/trackBackground/Баннер_Выходи_решать2.png'
import aiImg from '../../../assets/trackBackground/Баннер_ИИ_1.png'
import highloadImg from '../../../assets/trackBackground/Фон_p5dhEoL.png'
import designImg from '../../../assets/trackBackground/Снимок_экрана_2023-10-12_в_16.22.03.png'

function getImageForCategory(category) {
    switch (category) {
        case "EXTREME":
            return extremeImg;
        case "ML":
            return mlImg;
        case "AI":
            return aiImg;
        case "HIGHLOAD":
            return highloadImg;
        case "DESIGN" :
            return designImg;
        default:
            return defaultImg;
    }
}

const TournamentPreview = ({tournament, clickable=true}) => {
    return (
        <div className={classes.TournamentPreview}
             style={{backgroundImage: "linear-gradient( rgba(255, 255, 255, 0.2) 0%, rgba(0, 0, 0, 0.7) 0% )," + `url(${getImageForCategory(tournament.category)})`}}>
            <div className={classes.header}>
                <div>
                    <span style={{
                        backgroundColor: tournament.category === null ? "gray" : TrackValues[tournament.category].color
                    }}
                          className={classes.tag}>
                        {tournament.category === null ? "Вне категории" : TrackValues[tournament.category].text}
                    </span>
                </div>
                <div>
                    <span className={classes.tag}>Дата начала: {tournament.startDate}</span>
                    <span className={classes.tag}>Дата окончания: {tournament.finishDate}</span>
                    {tournament.finished && <span className={classes.tag} style={{backgroundColor:"#a73045"}}>Турнир закончился</span>}
                </div>
            </div>
            <div className={classes.body}>
                {clickable ?
                <Link to={"/tournaments/" + tournament.id} className={classes.title}>{tournament.title}</Link>:
                    <div className={classes.title}>{tournament.title} </div>

                }
                <div className={classes.description}>{tournament.text}</div>
            </div>
        </div>
    );
};

export default TournamentPreview;