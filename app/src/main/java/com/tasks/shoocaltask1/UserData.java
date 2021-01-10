package com.tasks.shoocaltask1;

import com.google.gson.JsonObject;

public class UserData {
    private final int id;
    private final String login;
    private final String state;
    private final JsonObject user;
    private final String repository_url;

    public UserData(int id, String login, String state, String repository_url, JsonObject user) {
        this.id = id;
        this.login = login;
        this.state = state;
        this.repository_url = repository_url;
        this.user = user;
    }

    public int getId() { return id; }

    public String getLogin() { return login; }

    public String getState() { return state; }

    public String getRepository_url() { return repository_url; }

    public JsonObject getUser() { return user; }

    @Override
    public String toString() {
        return "userId='" + id + '\'' +
                ", login='" + login + '\'' +
                ", state='" + state + '\'' +
                ", repositoriesURL='" + repository_url + "'\'" +
                ", user='" + user;
    }
}
