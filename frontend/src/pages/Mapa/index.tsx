import React from 'react';
import { Link } from 'react-router-dom';
import './styles.css'
import Footer from '../../components/Footer';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';

const initialPosition = {
    lat: -15.6184322,
    lng: -47.6570027
}

const Mapa = () => (
        <>
            <div className="mapa-container">
                <div className="mapa-content">
                <MapContainer center={initialPosition} zoom={13} scrollWheelZoom={false}>
                    <TileLayer
                    attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
                    url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                    />
                    <Marker position={initialPosition}>
                    <Popup>
                        A pretty CSS3 popup. <br /> Easily customizable.
                    </Popup>
                    </Marker>
                </MapContainer>
                </div>
            </div>
        <Footer />
        </>

);

export default Mapa;