import axios from "axios";

export default class TournamentService{
    static async getAll(){
        const response = await axios.get("http://localhost:8080/api/tournaments");
        return response.data;
    }
}