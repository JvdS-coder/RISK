import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import ApiService from "../../service/ApiService";

class Form extends React.Component {
    constructor(props) {
        super(props);
        this.state = { pcnr: '' };
        this.state = { merk: '' };
        this.state = { type: '' };
        this.state = { afdeling: '' };
        this.locatie = { locatie: '' };
        this.telnrcontactpersoon = { telnrcontactpersoon: '' };
        this.leverancier = { leveancier: '' };
        this.onderhoudscontract = { onderhoudscontract: '' };
        this.aankoopdatum = { aankoopdatum: '' };
        this.afloopdatum = { afloopdatum: '' };
        this.interngeheugen = { interngeheugen: '' };
        this.processor = { processor: '' };
        this.hd_1_capaciteit = { hd_1_capaciteit: '' };
        this.hd_1_type = { hd_1_type: '' };
        this.hd_2_capaciteit = { hd_2_capaciteit: '' };
        this.hd_2_type = { hd_2_type: '' };
        this.ext_hd_capaciteit = { ext_hd_capaciteit: '' };
        this.ext_hd_type = { ext_hd_type: '' };
        this.usba = { usba: '' };
        this.usbb = { usbb: '' };
        this.usbc = { usbc: '' };
        this.usbmini = { usbmini: '' };
        this.usbmicro = { usbmicro: '' };
    }
    myChangeHandler = (event) => {
        this.setState({pcnr: event.target.value});
        this.setState({merk: event.target.value});
        this.setState({type: event.target.value});
        this.setState({afdeling: event.target.value});
        this.setState({locatie: event.target.value});
        this.setState({leverancier: event.target.value});
        this.setState({telnrcontactpersoon: event.target.value});
        this.setState({onderhoudscontract: event.target.value});
        this.setState({aankoopdatum: event.target.value});
        this.setState({afloopdatum: event.target.value});
        this.setState({interngeheugen: event.target.value});
        this.setState({processor: event.target.value});
        this.setState({hd_1_capaciteit: event.target.value});
        this.setState({hd_1_type: event.target.value});
        this.setState({hd_2_capaciteit: event.target.value});
        this.setState({hd_2_type: event.target.value});
        this.setState({ext_hd_capaciteit: event.target.value});
        this.setState({ext_hd_type: event.target.value});
        this.setState({usba: event.target.value});
        this.setState({usbb: event.target.value});
        this.setState({usbc: event.target.value});
        this.setState({usbmini: event.target.value});
        this.setState({usbmicro: event.target.value});
    }
    render() {
        return (
            <form>
            <h1>Computer met ID: {this.state.pcnr}</h1>
        <input
        type='text'
        onChange={this.myChangeHandler}
        />
        </form>
    );
    }
}

ReactDOM.render(<Form />, document.getElementById('root'));

const domContainer = document.querySelector('#like_button_container');ReactDOM.render(e(LikeButton), domContainer);

