import React, { Component } from 'react'
import ApiService from "../../service/ApiService";

class AddUserComponent extends Component{

    constructor(props){
        super(props);
        this.state ={
            merk: '',
            type: '',
            afdeling: '',
            locatie: '',
            leveranciernr: '',
            aankoopdatum: '',
            afloopdatum: '',
            onderhoudscontract: '',
            serienummer: '',
            interngeheugen: '',
            hd_1_capaciteit: '',
            type_hd_1: '',
            hd_2_capaciteit: '',
            type_hd_2: '',
            ext_hd_capaciteit: '',
            ext_type_hd: '',
        }
        this.saveComputer = this.saveComputer.bind(this);
    }

    saveComputer = (e) => {
        e.preventDefault();
        let Computer = { pcnr: this.state.pcnr, 
            merk: this.state.merk,
			type: this.state.type,
            afdeling: this.state.afdeling,
            locatie: this.state.locatie,
            leveranciernr: this.state.leverancienr,
            aankoopdatum: this.state.afloopdatum,
            afloopdatum: this.state.afloopdatum,
            onderhoudscontract: this.state.onderhoudscontract,
            serienummer: this.state.serienummer,
            interngeheugen: this.state.interngeheugen,
            hd_1_capaciteit: this.state.hd_1_capaciteit,
            type_hd_1: this.state.type_hd_1,
            hd_2_capaciteit: this.state.hd_2_capaciteit,
            type_hd_2: this.state.type_hd_2,
            ext_hd_capaciteit: this.state.ext_hd_capaciteit,
            ext_type_hd: this.state.ext_type_hd,
		};,
        ApiService.addComputer(Computer)
            .then(res => {
                this.setState({message : 'Computer gegevens succesvol toegoevoegd.'});
                this.props.history.push('/Computer');
            });
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

    render() {
        return(
            <div>
                <h2 className="text-center">Add Computer</h2>
                <form>
                <div className="form-group">
                    <label>User Name:</label>
                    <input type="text" name="merk" className="form-control" value={this.state.merk} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>Password:</label>
                    <input type="password" placeholder="password" name="password" className="form-control" value={this.state.password} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>First Name:</label>
                    <input placeholder="First Name" name="firstName" className="form-control" value={this.state.firstName} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>Last Name:</label>
                    <input placeholder="Last name" name="lastName" className="form-control" value={this.state.lastName} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>Age:</label>
                    <input type="number" placeholder="age" name="age" className="form-control" value={this.state.age} onChange={this.onChange}/>
                </div>

                <div className="form-group">
                    <label>Salary:</label>
                    <input type="number" placeholder="salary" name="salary" className="form-control" value={this.state.salary} onChange={this.onChange}/>
                </div>

                <button className="btn btn-success" onClick={this.saveUser}>Save</button>
            </form>
    </div>
        );
    }
}

export default AddComputerComponent;

