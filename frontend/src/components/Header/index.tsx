import React from 'react'
import './styles.css';
import Logo from '../../assets/logo.png';


const Header = () => (
    <header className="main-header">
        <div className="container">
            <img src={Logo} className="image-size"/>
        </div>
    </header> 
);

export default Header;