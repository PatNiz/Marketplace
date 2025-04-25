package pl.niziolekp.app.graphservice.domain.service;

import pl.niziolekp.app.graphservice.domain.model.Connection;

import java.util.List;

public interface GraphQueryUseCase {
    List<Connection> getConnections(String userId);
}
