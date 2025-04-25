package pl.niziolekp.app.graphservice.domain.port;

import pl.niziolekp.app.graphservice.domain.model.Connection;

import java.util.List;

public interface GraphRepositoryPort {
    List<Connection> findConnectionsByUserId(String userId);
}
