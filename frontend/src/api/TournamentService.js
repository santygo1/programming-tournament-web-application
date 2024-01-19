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
}