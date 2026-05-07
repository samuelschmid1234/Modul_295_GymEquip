package ch.schmid.samuel.gymEquip.security;

public class Roles {
    public static final String Admin = "admin";
    public static final String Read = "read";
    public static final String Update = "update";

    public static final String CanRead = "hasAnyAuthority('read', 'update', 'admin')";
    public static final String CanUpdate = "hasAnyAuthority('update', 'admin')";
    public static final String IsAdmin = "hasAuthority('admin')";
}