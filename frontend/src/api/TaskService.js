import axios from "axios";

export default class TaskService{
    static async getAll(){
        const response = await axios.get("http://localhost:8080/api/tasks");
        return response.data;
    }
}