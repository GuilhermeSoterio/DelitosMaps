import './styles.css';
import { ReactComponent as YoutubeIcon } from './youtube.svg';
import { ReactComponent as LinkedinIcon } from './linkedin.svg';
import { ReactComponent as InstagramIcon } from './instagram.svg';

function Footer() {
    return (
        <footer className="main-footer">
                App desenvolvido pelo Guilherme Sotério no projeto de TCC do IFB- Instituto Federal de Brasília
            <div className="footer-icons">
                <a href="https://www.youtube.com/channel/UC6DK2YOWm0OmgdB6z_j62CA" target="_new">
                    <YoutubeIcon />
                </a>
                <a href="https://www.linkedin.com/in/guilhermesoterio" target="_new">
                    <LinkedinIcon />
                </a>
                <a href="https://www.instagram.com/guilhermesoterio" target="_new">
                    <InstagramIcon />
                </a>
            </div>
        </footer>
    )
}

export default Footer;