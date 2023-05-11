package tech.api.utils;

import lombok.Getter;

public enum Schemas {

    LISTAR_ALL_USERS("schemas/listarAllUsersSchema.json"),
    LISTAR_SINGLE_USER("schemas/listarSingleUserSchema.json");

    @Getter
    String path;

    private Schemas(String path) {
        this.path = path;
    }

}
