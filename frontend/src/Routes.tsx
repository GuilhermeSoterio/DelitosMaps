import React from 'react';
import { BrowserRouter , Switch, Route } from 'react-router-dom';
import Home from './pages/Home';
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
        </Switch>
    </BrowserRouter>
);

export default Routes;