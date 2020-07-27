import React, { Component } from 'react'
import ApiService from "../../service/ApiService";

class ListComputer extends Component {

    constructor(props) {
        super(props)
        this.state = {
            computer: [],
            message: null
        }
        this.deleteComputer = this.deleteComputer.bind(this);
        this.editComputer = this.editComputer.bind(this);
        this.addComputer = this.addComputer.bind(this);
        this.reloadComputerList = this.reloadComputerList.bind(this);
    }

    componentDidMount() {
        this.reloadComputerList();
    }

    reloadComputerList() {
        ApiService.fetchComputer()
            .then((res) => {
                this.setState({computer: res.data.result})
            });
    }

    deleteComputer(computerId) {
        ApiService.deleteComputer(computerId)
           .then(res => {
               this.setState({message : 'Computer gegevens succesvol verwijderd.'});
               this.setState({computer: this.state.computer.filter(computer => computer.id !== computerId)});
           })

    }

    editComputer(id) {
        window.localStorage.setItem("computerId", id);
        this.props.history.push('/edit-computer');
    }

    addComputer() {
        window.localStorage.removeItem("computerId");
        this.props.history.push('/add-computer');
    }

    render() {
        return (
            <div>
                <h2 className="text-center">User Details</h2>
                <button className="btn btn-danger" onClick={() => this.addUser()}> Add User</button>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th className="hidden">Id</th>
                            <th>FirstName</th>
                            <th>LastName</th>
                            <th>UserName</th>
                            <th>Age</th>
                            <th>Salary</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.users.map(
                        user =>
                                    <tr key={user.id}>
                                        <td>{user.firstName}</td>
                                        <td>{user.lastName}</td>
                                        <td>{user.username}</td>
                                        <td>{user.age}</td>
                                        <td>{user.salary}</td>
                                        <td>
                                            <button className="btn btn-success" onClick={() => this.deleteUser(user.id)}> Delete</button>
                                            <button className="btn btn-success" onClick={() => this.editUser(user.id)}> Edit</button>
                                        </td>
                                    </tr>
                            )
                        }
                    </tbody>
                </table>

            </div>
        );
    }

}

export default ListComputer;
