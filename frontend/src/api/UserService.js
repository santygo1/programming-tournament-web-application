import axios from "axios";

export default class UserService {
    static async getById(id) {
        const response = await axios.get("/api/user");
        return response.data;
    }

}