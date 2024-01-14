import React from 'react';
import classes from "./MainPage.module.css";
import Navbar from "../../components/Navbar/Navbar.jsx";
import {Button, Card, Col, Container, Image, Row, Stack} from "react-bootstrap";
import highload from "../../assets/highload.png"
import proc from "../../assets/proc.png"
import ListPreview from "./components/ListPreview/ListPreview.jsx";
import BasicLink from "../../components/BasicLink/BasicLink.jsx";
import {faLightbulb} from "@fortawesome/free-solid-svg-icons";
import {faTrophy, faMedal} from "@fortawesome/free-solid-svg-icons";
import CardPreview from "./components/CardPreview/CardPreview.jsx";
import Achievement from "./components/Achievement.jsx";
import Possibility from "./components/Possibility/Possibility.jsx";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import Footer from "../../components/BasicLink/Footer/Footer.jsx";

const MainPage = (props) => {

  return (
      <>
          <Navbar/>
          <Container  fluid className={[classes.MainPage,"Page"].join(" ")}>
              <Row className={classes.welcome}>
                  <Col className={classes.info}>
                      <div>
                          <h1>all cups</h1>
                          <h3 className={"thin"}>IT-Соревнования для специалистов и начинающих</h3>
                      </div>
                      <p style={{width: "50%"}}>Решай креативные задачи, обменивайся опытом, открывай новые направления, выигрывай ценные призы</p>
                  </Col>
                  <Col  style={{display:"flex", alignItems: "center", justifyContent: "center"}}>
                      <Image src={highload} height={650} width={650}/>
                  </Col>
              </Row>

              <ListPreview title={"Ближайшие турниры"} link={<BasicLink title={"ко всем соревнованиям"} href={"#соревнования"}/>}>
                  <CardPreview title={"Международная олипиада"}
                               text={"Международная олимпиада …\n" +
                      "Собственная международная олимпиада Университета Иннополис по профилю «Робототехника‎». Innopolis Open входит в перечень олимпиад школьников и их уровней Российского совета олимпиад школьников, утвержденный Минобрнауки."}
                               href={"#sAdasd"} />
                  <CardPreview title={"Международная олипиада"}
                               text={"Международная олимпиада …\n" +
                                   "Собственная международная олимпиада Университета Иннополис по профилю «Робототехника‎». Innopolis Open входит в перечень олимпиад школьников и их уровней Российского совета олимпиад школьников, утвержденный Минобрнауки."}
                               href={"#sAdasd"} />
                  <CardPreview title={"Международная олипиада"}
                               text={"Международная олимпиада …\n" +
                                   "Собственная международная олимпиада Университета Иннополис по профилю «Робототехника‎». Innopolis Open входит в перечень олимпиад школьников и их уровней Российского совета олимпиад школьников, утвержденный Минобрнауки."}
                               href={"#sAdasd"} />
              </ListPreview>


              <Row>
                  <Container>
                      <h1 style={{color: "#b066f0"}}>Возможности платформы</h1>
                      <Row style={{marginTop: "120px"}}>
                          <Col  style={{display:"flex", alignItems: "center", justifyContent: "center"}}>
                              <Image src={proc} height={500} width={500}/>
                          </Col>
                          <Col className={classes.achievments}>
                              <Achievement title={"15"} text={"ежегодных соревнований"}/>
                              <Achievement title={"300 тыс. +"} text={"участников на платформе"} />
                              <Achievement title={"351 тыс."} text={"Загруженных решений"} />
                          </Col>
                      </Row>

                      <div className={classes.possibilities}>
                          <Possibility
                              icon={<FontAwesomeIcon icon={faLightbulb} color={"#b066f0"} size={"2xl"}/> }
                              text={"Творческие задачи по направлениям AI, HighLoad, ML, Спортивное программирование"}/>
                          <Possibility
                              icon={<FontAwesomeIcon icon={faMedal} color={"#eb4d86"} size={"2xl"}/> }
                              text={"Награда за победы, сертификаты, возможность трудоустройства в компании"}/>
                          <Possibility
                              icon={<FontAwesomeIcon icon={faTrophy} color={"#50c3a0"} size={"2xl"}/> }
                              text={"ТКрупные соревнования от топовых компаний и олимпиады от ведущих вузов"}/>
                      </div>
                  </Container>
              </Row>

              <ListPreview title={"Песочница"} link={<BasicLink title={"в песочницу"} href={"#песочница"}/>}>
                  <CardPreview title={"Международная олипиада"}
                               text={"Международная олимпиада …\n" +
                                   "Собственная международная олимпиада Университета Иннополис по профилю «Робототехника‎». Innopolis Open входит в перечень олимпиад школьников и их уровней Российского совета олимпиад школьников, утвержденный Минобрнауки."}
                               href={"#sAdasd"} />
                  <CardPreview title={"Международная олипиада"}
                               text={"Международная олимпиада …\n" +
                                   "Собственная международная олимпиада Университета Иннополис по профилю «Робототехника‎». Innopolis Open входит в перечень олимпиад школьников и их уровней Российского совета олимпиад школьников, утвержденный Минобрнауки."}
                               href={"#sAdasd"} />
                  <CardPreview title={"Международная олипиада"}
                               text={"Международная олимпиада …\n" +
                                   "Собственная международная олимпиада Университета Иннополис по профилю «Робототехника‎». Innopolis Open входит в перечень олимпиад школьников и их уровней Российского совета олимпиад школьников, утвержденный Минобрнауки."}
                               href={"#sAdasd"} />

                  <CardPreview title={"Международная олипиада"}
                               text={"Международная олимпиада …\n" +
                                   "Собственная международная олимпиада Университета Иннополис по профилю «Робототехника‎». Innopolis Open входит в перечень олимпиад школьников и их уровней Российского совета олимпиад школьников, утвержденный Минобрнауки."}
                               href={"#sAdasd"} />
              </ListPreview>
              <Footer/>
          </Container>
      </>
  );
};

export default MainPage;