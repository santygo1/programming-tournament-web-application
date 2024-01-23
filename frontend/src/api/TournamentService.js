import axios from "axios";

export default class TournamentService{
    static async getAll(track, filter, sort){
        const response = await axios.get(
            "/api/tournaments",
            {
                params:{
                    track: track,
                    filter: filter,
                    sort: sort
                }
            }
        );
        return response.data;
    }

    static async getById(id) {
        const response = await axios.get(`/api/tournaments/${id}`);
        return response.data;
    }

    static async createTournament(tournament){
        const response = await axios.post(
            "/api/tournaments",
            tournament, {
            headers:{
                "x-authorized-user": localStorage.getItem("userId")
            }
        })
        return response.data;
    }
}