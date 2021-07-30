import React from 'react'
import './styles.css';
import Logo from '../../assets/logo.png';
import { Link } from 'react-router-dom';


const Header = () => (
    <header className="main-header">
        <Link to ="/">
            <div className="container-logo">
                <img src={Logo} className="image-size" alt="logotipo DelitosMaps"/>
            </div>
        </Link>
                <nav>
                    <ul className="nav_links">
                    <Link to ="/">
                        <li>Home</li>
                    </Link>
                    <Link to ="/mapa">
                        <li><a href="#news">Mapa</a></li>
                    </Link>
                    <Link to ="/ocorrencias">
                        <li><a href="#contact">Lista de crimes</a></li>
                    </Link> 
                    <Link to ="/">
                        <li><a href="#about">Telefones</a></li>
                    </Link>
                    </ul>
                </nav>
    </header> 
);

export default Header;