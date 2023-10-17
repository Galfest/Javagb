package com.gb.java.hw.hw2.server.repo;

public interface Repository<T> {
    void save(T text);
    T load();
}
