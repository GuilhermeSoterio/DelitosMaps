import React from 'react';
import Homeimage from '../../assets/home-image.png';
import { Link } from 'react-router-dom';
import './styles.css'

const Home = () => (
    <>
       <div className="home-container">
                <div className="home-content">
                    <div className="home-actions">
                        <h1 className="home-title">
                            PLANALTINA <br />MAIS <br />SEGURA
                        </h1>
                        <h3 className="home-subtitle">
                            INFORMAÇÃO É SEGURANÇA!JUNTOS POR
                            UMA CIDADE MAIS SEGURA E SEM VIOLÊNCIA!
                        </h3>
                        <Link to ="/ocorrencias">
                            <div className="home-actions">
                                <button className="home-btn-order">
                                    <p>
                                        SAIBA SOBRE OS CRIMES
                                    </p>
                                </button>
                            </div>
                        </Link>
                    </div>
                    <div className="home-image">
                        <img src={Homeimage} className="image-size"/>
                    </div>
                </div>
            </div>
    </>
    /*
    <Link to="/orders" className="home-btn-order">
                            OLHAR OS INCIDENTES
                        </Link>
    */
);

export default Home;