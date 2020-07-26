import axios from 'axios';

const USER_API_BASE_URL = 'http://localhost:8080/computer';

class ApiService {

    fetchComputer() {
        return axios.get(USER_API_BASE_URL);
    }

    fetchComputerById(computerId) {
        return axios.get(USER_API_BASE_URL + '/' + computerId);
    }

    deleteComputer(computerId) {
        return axios.delete(USER_API_BASE_URL + '/' + computerId);
    }

    addComputer(computer) {
        return axios.post(""+USER_API_BASE_URL, computer);
    }

    editComputer(computer) {
        return axios.put(USER_API_BASE_URL + '/' + computer.id, computer);
    }

}

export default new ApiService();
