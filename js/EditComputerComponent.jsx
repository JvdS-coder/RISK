import React, { Component } from 'react'
import ApiService from "../../service/ApiService";

class EditComputerComponent extends Component {

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
        this.loadComputer = this.loadComputer.bind(this);
    }

    componentDidMount() {
        this.loadComputer();
    }

    loadComputer() {
        ApiService.fetchComputerById(window.localStorage.getItem("pcnr"))
            .then((res) => {
                let computer = res.data.result;
                this.setState({
                id: computer.pcnr,
                merk: computer.merk,
                type: computer.type,
                afdeling: computer.afdeling,
                locatie: computer.locatie,
		leveranciernr: computer.leveranciernr,
            	aankoopdatum: computer.aankoopdatum,
		afloopdatum: computer.afloopdatum,
	    	onderhoudscontract: computer.onderhoudscontract,
	    	serienummer: computer.serienummer,
  	    	interngeheugen: computer.interngeheugen,
  	    	hd_1_capaciteit: computer.hd_1_capaciteit,
	    	type_hd_1: computer.type_hd_1,
	    	hd_2_capaciteit: computer.hd_2_capaciteit,
	    	type_hd_2: computer.type_hd_2,
	    	ext_hd_capaciteit: computer.ext_hd_capaciteit,
	    	ext_type_hd: computer.ext_type_hd,
                })
            });
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

    saveComputer = (e) => {
        e.preventDefault();
        let computer = { pcnr: this.state.pcnr, 
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
	    	     type_hd_2: type_hd_2,
	    	     ext_hd_capaciteit: this.state.ext_hd_capaciteit,
	    	     ext_type_hd: this.state.ext_type_hd
		   };
        ApiService.editComputer(computer)
            .then(res => {
                this.setState({message : 'Computer gegevens succesvol aangepast.'});
                this.props.history.push('/computer');
            });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Edit User</h2>
                <form>

                    <div className="form-group">
                        <label>User Name:</label>
                        <input type="text" placeholder="username" name="username" className="form-control" readonly="true" defaultValue={this.state.username}/>
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

export default EditComputerComponent;

