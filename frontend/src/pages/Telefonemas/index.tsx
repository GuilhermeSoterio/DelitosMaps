import React from 'react';
import './styles.css'
import Footer from '../../components/Footer';


const Telefonemas = () => (

        <>
            <div className="container">
                <div className="container-content1">
                    <h4>POLICIA CÍVIL</h4>
                    <p> 191</p>

                    <h4>POLICIA MILITAR</h4>
                    <p> 190</p>

                    <h4>POLICIA RODOVIÁRIA FEDERAL</h4>
                    <p> (61) 3395-9330</p>

                    <h4>POLICIA RODOVIÁRIA ESTADUAL</h4>
                    <p> (61) 3395-9330</p>

                    <h4>VIOLÊNCIA CONTRA A MULHER</h4>
                    <p> 180</p>
                </div>

                <div className="container-content2">
                    <h4>16ª DP- PLANALTINA</h4>
                    <p> (61) 3207-7472</p>

                    <h4>31ª DP- PLANALTINA</h4>
                    <p> (61) 3207-8411</p>

                    <h4>DIREITOS HUMANOS</h4>
                    <p> 100</p>
                </div>
            </div>
        <Footer />

        </>

);

export default Telefonemas;