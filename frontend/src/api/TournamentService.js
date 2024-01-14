import axios from "axios";

export default class TournamentService{
    static async getAll(){
        const response = await axios.get("/api/tournaments");
    }
}