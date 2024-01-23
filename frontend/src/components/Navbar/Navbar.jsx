import React from 'react';
import {Container, Nav, Navbar as BNavbar} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faTerminal} from "@fortawesome/free-solid-svg-icons";
import classes from "./Navbar.module.css";
import {Link} from "react-router-dom";
import "bootstrap"

const Navbar = (props) => {


    return (
        <BNavbar variant={"dark"} className={classes.Navbar} fixed={"top"}>
            <Container>
                <Link className={"navbar-brand"} to={"/"}>
                    <FontAwesomeIcon icon={faTerminal}/>{' '}
                    {"CodeRise"}
                </Link>

                <Nav className="me-auto">
                    <Link className={"nav-link"} to={"/tournaments"}>Соревнования</Link>
                    <Link className={"nav-link"} to={"/tasks"}>Песочница</Link>
                </Nav>

                <Nav>
                </Nav>
            </Container>
        </BNavbar>
    );
};

export default Navbar;