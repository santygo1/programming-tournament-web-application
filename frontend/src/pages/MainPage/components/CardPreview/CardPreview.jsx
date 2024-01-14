import React from 'react';
import classes from "./CardPreview.module.css";
import {Card} from "react-bootstrap";

const CardPreview = ({title, text, onClick, style=20}) => {
    return (
        <Card text={"white"} bg={"transparent"} className={classes.CardPreview}>
            <Card.Body className={classes.body}>
                <Card.Title>{title}</Card.Title>
                <Card.Text className={classes.text}>
                    {text}
                </Card.Text>
            </Card.Body>
        </Card>
    );
};

export default CardPreview;