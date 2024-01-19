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
}