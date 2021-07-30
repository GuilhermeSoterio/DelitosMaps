import React from 'react';
import { BrowserRouter , Switch, Route } from 'react-router-dom';
import Home from './pages/Home';
import Mapa from './pages/Mapa';
import Telefonemas from './pages/Telefonemas';
import Ocorrencias from './pages/Ocorrencias';
import Header from './components/Header';

const Routes = () => (
    <BrowserRouter>
        <Header />
        <Switch>
            <Route path="/" exact>
                <Home />
            </Route>
            <Route path="/ocorrencias">
                <Ocorrencias />
            </Route>
            <Route path="/mapa">
                <Mapa />
            </Route>
            <Route path="/telefonemas">
                <Telefonemas />
            </Route>
        </Switch>
    </BrowserRouter>
);

export default Routes;