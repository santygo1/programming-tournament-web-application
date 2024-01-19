import axios from "axios";

export default class TaskService {
    static async getAll(track, sort) {
        const response = await axios.get("/api/tasks",
            {
                params: {
                    track: track,
                    sort: sort
                }
            });
        return response.data;
    }

    static async getById(id){
        const response = await axios.get(`/api/tasks/${id}`);
        return response.data;
    }

    static async getTournamentTasks(id){
        const response = await axios.get(`/api/tournaments/${id}/tasks`)
        return response.data;
    }
}