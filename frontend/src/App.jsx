import MainPage from "./pages/MainPage/MainPage.jsx";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Navbar from "./components/Navbar/Navbar.jsx";
import React from "react";
import TournamentsPage from "./pages/TournamentsPage/TournamentsPage.jsx";
import TasksPage from "./pages/TasksPage/TasksPage.jsx";
import TaskIdPage from "./pages/TaskIdPage/TaskIdPage.jsx";


const routes = [
    {path: "/", elem: <MainPage/>},
    {path: "/tournaments", elem: <TournamentsPage/>},
    {path: "/tasks", elem: <TasksPage/>},
    {path: "/tasks/:id", elem: <TaskIdPage />, exact: true}
]


function App() {

    return (
        <>
            <BrowserRouter>
                <Navbar/>
                <Routes>
                    {routes.map(
                        (r, i) => <Route key={i} path={r.path} element={r.elem} />
                    )}
                </Routes>
            </BrowserRouter>
        </>
    )
}

export default App
