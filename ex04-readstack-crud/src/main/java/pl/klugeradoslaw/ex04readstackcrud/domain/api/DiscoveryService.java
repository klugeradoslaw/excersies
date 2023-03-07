package pl.klugeradoslaw.ex04readstackcrud.domain.api;

import pl.klugeradoslaw.ex04readstackcrud.domain.discovery.Discovery;
import pl.klugeradoslaw.ex04readstackcrud.domain.discovery.DiscoveryDao;

import java.util.List;
import java.util.stream.Collectors;

public class DiscoveryService {

    private final DiscoveryDao discoveryDao = new DiscoveryDao();
    public List<DiscoveryBasicInfoDto> findAll() {
        return discoveryDao.findAll()
                .stream().map(DiscoveryMapper::map)
                .collect(Collectors.toList());
    }
    private static class DiscoveryMapper {
        static DiscoveryBasicInfoDto map(Discovery d) {
            return new DiscoveryBasicInfoDto(
                    d.getTitle(),
                    d.getUrl(),
                    d.getDescription(),
                    d.getDateAdded()
            );
        }
    }
}
