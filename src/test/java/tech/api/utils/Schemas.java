package tech.api.utils;

import lombok.Getter;

public enum Schemas {

    LISTAR_ALL_USERS("schemas/listarAllUsersSchema.json"),
    LISTAR_ALL_USERS_DELAY("schemas/listarAllUsersDelaySchema.json"),
    LISTAR_SINGLE_USER("schemas/listarSingleUserSchema.json"),
    LISTAR_ALL_RESOURCES("schemas/listarAllResourcesSchema.json"),
    LISTAR_SINGLE_RESOURCES("schemas/listarSingleResoucesSchema.json"),
    CRIAR_USER_RESOURCES("schemas/CriarUserSchema.json"),
    ALTERAR_USER_RESOURCES("schemas/AlterarUserSchema.json");

    @Getter
    String path;

    private Schemas(String path) {
        this.path = path;
    }

}
