package ru.alexeyk2021.dbguipanel.models;

public class FileStorage {
    private int fileStorageId;
    private int repostId;
    private int clientId;

    public FileStorage(int fileStorageId, int repostId, int clientId) {
        this.fileStorageId = fileStorageId;
        this.repostId = repostId;
        this.clientId = clientId;
    }

    public int getFileStorageId() {
        return fileStorageId;
    }

    public int getRepostId() {
        return repostId;
    }

    public int getClientId() {
        return clientId;
    }
}
