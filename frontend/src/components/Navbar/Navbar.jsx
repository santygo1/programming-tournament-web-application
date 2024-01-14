import React from 'react';
import {Container, Nav, Navbar as BNavbar} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faTerminal} from "@fortawesome/free-solid-svg-icons";
import classes from "./Navbar.module.css";

const Navbar = (props) => {


    return (
        <BNavbar variant={"dark"} className={classes.Navbar} fixed={"top"}>
            <Container>
                <BNavbar.Brand href="#home">
                    <FontAwesomeIcon icon={faTerminal}/>{' '}
                    all cups
                </BNavbar.Brand>

                <Nav className="me-auto">
                    <Nav.Link href="#tournaments">Соревнования</Nav.Link>
                    <Nav.Link href="#sand">Песочница</Nav.Link>
                    <Nav.Link href="#results">Результаты</Nav.Link>
                    <Nav.Link href="#battles">Битвы</Nav.Link>
                </Nav>

                <Nav>
                </Nav>
            </Container>
        </BNavbar>
    );
};

export default Navbar;