import React from 'react';
import classes from "./CardPreview.module.css";
import {Card} from "react-bootstrap";

const CardPreview = ({data}) => {
    return (
        <Card text={"white"} bg={"transparent"} className={classes.CardPreview}>
            <Card.Body className={classes.body}>
                <Card.Title>{data.title}</Card.Title>
                <Card.Text>{data.text}</Card.Text>
            </Card.Body>
        </Card>
    );
};

export default CardPreview;