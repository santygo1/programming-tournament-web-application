import React from 'react';
import classes from "./Footer.module.css";

const Footer = (props) => {
    return (
        <div className={classes.Footer}>
            <div className={classes.socials}>
                <h3>Остались вопросы?</h3>
                <div >
                    <a href={"#FAQ"}>FAQ</a>
                    <a href={"#ВК"}>ВК</a>
                    <a href={"#почта"}>почта</a>
                </div>
            </div>

            <div className={classes.terms}>
                <div>@ Designed by Danil Spirin</div>
                <a href={"#Конфиденциальность"}>Конфиденциальность</a>
                <a href={"#Пользовательское соглашение"}>Пользовательское соглашение</a>
            </div>
        </div>
    );
};

export default Footer;