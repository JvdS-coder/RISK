import React from 'react';
import {
    BrowserRouter as Router,
    Switch,
    Route,
} from 'react-router-dom';

import ComputerToevoegenPage from "./pages/computerToevoegen/computerToevoegenPage";
import ComputerRaadplegenPage from "./pages/computerRaadplegen/computerRaadplegenPage";
import ComputerWijzigenPage from "./pages/computerWijzigen/computerWijzigenPage";
import ComputerVerwijderenPage from "./pages/computerVerwijderen/computerVerwijderenPage";
import RandapparatuurToevoegenPage from "./pages/randapparatuurToevoegen/randapparatuurToevoegenPage";
import RandapparatuurRaadplegenPage from "./pages/randapparatuurRaadplegen/randapparatuurRaadplegenPage";
import RandapparatuurWijzigenPage from "./pages/randapparatuurWijzigen/randapparatuurWijzigenPage";
import RandapparatuurVerwijderenPage from "./pages/randapparatuurVerwijderen/randapparatuurVerwijderenPage";
import SoftwareToevoegenPage from "./pages/softwareToevoegen/softwareToevoegenPage";
import SoftwareRaadplegenPage from "./pages/softwareRaadplegen/softwareRaadplegenPage";
import SoftwareWijzigenPage from "./pages/softwareWijzigen/softwareWijzigenPage";
import SoftwareVerwijderenPage from "./pages/softwareVerwijderen/softwareVerwijderenPage";
import LeverancierToevoegenPage from "./pages/leverancierToevoegen/leverancierToevoegenPage";
import LeverancierRaadplegenPage from "./pages/leverancierRaadplegen/leverancierRaadplegenPage";
import LeverancierWijzigenPage from "./pages/leverancierWijzigen/leverancierWijzigenPage";
import LeverancierVerwijderenPage from "./pages/leverancierVerwijderen/leverancierVerwijderenPage";
import StoringToevoegenPage from "./pages/storingToevoegen/storingToevoegenPage";
import StoringRaadplegenPage from "./pages/storingRaadplegen/storingRaadplegenPage";
import StoringWijzigenPage from "./pages/storingWijzigen/storingWijzigenPage";
import StoringVerwijderenPage from "./pages/storingVerwijderen/storingVerwijderenPage";
import KnowledgebaseRaadplegenPage from "./pages/knowledegebaseRaadplegen/knowledgebaseRaadplegenPage";

function App() {
    return (
        <Router>
            <Switch>
                <Route path="/computer-toevoegen">
                    <ComputerToevoegenPage/>
                </Route>
                <Route path="/randapparatuur-toevoegen">
                    <RandapparatuurToevoegenPage/>
                </Route>
                <Route path="/software-toevoegen">
                    <SoftwareToevoegenPage/>
                </Route>
                <Route path="/leverancier-toevoegen">
                    <LeverancierToevoegenPage/>
                </Route>
                <Route path="/storing-toevoegen">
                    <StoringToevoegenPage/>
                </Route>
                <Route path="/computer-raadplegen">
                    <ComputerRaadplegenPage/>
                </Route>
                <Route path="/randapparatuur-raadplegen">
                    <RandapparatuurRaadplegenPage/>
                </Route>
                <Route path="/software-raadplegen">
                    <SoftwareRaadplegenPage/>
                </Route>
                <Route path="/leverancier-raadplegen">
                    <LeverancierRaadplegenPage/>
                </Route>
                <Route path="/storing-raadplegen">
                    <StoringRaadplegenPage/>
                </Route>
                <Route path="/knowledgebase-raadplegen">
                    <KnowledgebaseRaadplegenPage/>
                </Route>
                <Route path="/computer-wijzigen">
                    <ComputerWijzigenPage/>
                </Route>
                <Route path="/randapparatuur-wijzigen">
                    <RandapparatuurWijzigenPage/>
                </Route>
                <Route path="/software-wijzigen">
                    <SoftwareWijzigenPage/>
                </Route>
                <Route path="/leverancier-wijzigen">
                    <LeverancierWijzigenPage/>
                </Route>
                <Route path="/storing-wijzigen">
                    <StoringWijzigenPage/>
                </Route>
                <Route path="/computer-verwijderen">
                    <ComputerVerwijderenPage/>
                </Route>
                <Route path="/randapparatuur-verwijderen">
                    <RandapparatuurVerwijderenPage/>
                </Route>
                <Route path="/software-verwijderen">
                    <SoftwareVerwijderenPage/>
                </Route>
                <Route path="/leverancier-verwijderen">
                    <LeverancierVerwijderenPage/>
                </Route>
                <Route path="/storing-verwijderen">
                    <StoringVerwijderenPage/>
                </Route>
            </Switch>
        </Router>
    );
}

export default App;
