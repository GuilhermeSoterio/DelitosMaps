import React from 'react'
import './styles.css';
import Logo from '../../assets/logo.png';
import { Link } from 'react-router-dom';


const Header = () => (
    <header className="main-header">
        <Link to ="/">
            <div className="container">
                <img src={Logo} className="image-size"/>
            </div>
        </Link>
    </header> 
);

export default Header;