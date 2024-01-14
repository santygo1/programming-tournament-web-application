import React from 'react';
import classes from "./ListPreview.module.css";
import {Container, Row} from "react-bootstrap";

const ListPreview = ({title, children, link}) => {
    return (
        <Row className={classes.ListPreview}>
            <div className={classes.title}>
                <h2>{title}</h2>
                {link}
            </div>

            <Container className={classes.cardContainer}>
                {children}
            </Container>
        </Row>
    );
};

export default ListPreview;