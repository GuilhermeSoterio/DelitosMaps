import React, { useEffect, useState} from 'react';
import axios from 'axios';
import './styles.css';
import { OccurrencesResponse } from './types';
import { formatDate } from './helpers';
import Pagination from './Pagination';
import Footer from '../../components/Footer';

const BASE_URL = 'http://localhost:8080'

const Occurrences = () => {
    const [ occurrencesResponse, setOccurrenceResponse] = useState<OccurrencesResponse>();
    const [activePage, setActivePage] = useState(0);

    useEffect(() => {
        axios.get(`${BASE_URL}/occurrences/pages?linesPerPage=2&page=${activePage}`)
        .then(response => setOccurrenceResponse(response.data));
    }, [activePage]);

    const handlePageChange = (index: number) => {
        setActivePage(index);
    }

    return (
        <>
        <div className="page-container">
            <table className="occurrences-table" cellPadding="0" cellSpacing="0">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Dia da semana</th>
                        <th>Crime</th>
                        <th className="centralizando">Descrição do crime</th>
                        <th>Bairro</th>
                        <th>Gênero da vítima</th>
                        <th>Idade da vítima</th>
                    </tr>
                </thead>
                <tbody>
                    {occurrencesResponse?.content.map(occurrence => (
                     <tr key={occurrence.id}>
                        <td className="Instant-size">{formatDate(occurrence.moment)}</td>
                        <td>{occurrence.dayOfTheWeek}</td>
                        <td className="Crime-size">{occurrence.crimeTypeName}</td>
                        <td className="descricao-size">{occurrence.description}</td>
                        <td>{occurrence.district}</td>
                        <td>{occurrence.victimGenre}</td>
                        <td>{occurrence.victimAge}</td>
                     </tr>
                     ))}

                </tbody>
            </table>
            <Pagination 
                activePage={activePage}
                goToPage={handlePageChange} 
                totalPages={occurrencesResponse?.totalPages}
            />
            
        </div>
        <Footer />
        </>
    );
    
}
<Footer />

/*

const BASE_URL = 'http://localhost:8080'

const Occurrences = () => {
    const [ occurrencesResponse, setOccurrenceResponse] = useState<OccurrencesResponse>();

    useEffect(() => {
        axios.get(`${BASE_URL}/occurrences?linesPerPage=12`)
        .then(response => setOccurrenceResponse(response.data));
    }, []);

    return (
        <div className="page-container">
            <table className="occurrences-table" cellPadding="0" cellSpacing="0">
                <thead>
                    <tr>
                        <th>Instante</th>
                        <th>Dia da semana</th>
                        <th>Crime</th>
                        <th className="centralizando">Descrição do crime</th>
                        <th>Bairro</th>
                        <th>Gênero da vítima</th>
                        <th>Idade da vítima</th>
                    </tr>
                </thead>
                <tbody>
                    {occurrencesResponse?.content.map(occurrence => (
                     <tr key={occurrence.id}>
                        <td>{occurrence.moment}</td>
                        <td>{occurrence.crimeTypeName}</td>
                        <td>{occurrence.description}</td>
                        <td className="descricao-size">{occurrence.moment}</td>
                     </tr>
                     ))}

                </tbody>
            </table>
        </div>
    );
}
*/

export default Occurrences;