package org.sixdouglas.formation.spring.irrigation;

import org.sixdouglas.formation.spring.irrigation.producer.GreenHouseProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import java.time.Instant;
import java.util.UUID;

@Component
public class DripIrrigation {
    private static Logger LOGGER = LoggerFactory.getLogger(DripIrrigation.class);

    public Flux<Drop> followDrops() {
        return Flux.interval(Duration.ofMillis(20))
                .map(along -> Drop.builder().
                        dropperId(1).
                        greenHouseId(1).
                        rowId(1).
                        instant(Instant.now()).
                        build());
    }

    public Flux<Drop> followDropper(int greenHouseId, int rowId, int dropperId) {
        return GreenHouseProducer.getDrops().filter(drop ->
                drop.getGreenHouseId() == greenHouseId &&
                        drop.getRowId() == rowId &&
                        drop.getDropperId() == dropperId);
    }

    public Flux<DetailedDrop> followDetailedDropper(int greenHouseId, int rowId, int dropperId) {
        return GreenHouseProducer.getDrops()
                .filter(drop -> drop.getGreenHouseId() == greenHouseId
                        && drop.getRowId() == rowId
                        && drop.getDropperId() == dropperId)
                .flatMap(this::getDetailedDrop);
    }

    private Mono<DetailedDrop> getDetailedDrop(Drop drop) {
        return GreenHouseProducer
                .getDropper(drop.getGreenHouseId(), drop.getRowId(), drop.getDropperId())
                .map(x -> DetailedDrop
                        .builder()
                        .uuid(UUID.randomUUID().toString())
                        .greenHouse(x)
                        .instant(Instant.now())
                        .build());
    }
}
