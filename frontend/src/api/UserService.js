import axios from "axios";

export default class UserService {
    static async getById(id) {
        const response = await axios.get(`/api/users/${id}`, {
            headers:{
                "x-authorized-user": localStorage.getItem("userId")
            }
        });
        return response.data;
    }

}